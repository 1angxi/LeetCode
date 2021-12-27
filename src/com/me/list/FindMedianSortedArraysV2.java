package com.me.list;

import com.sun.tools.corba.se.idl.constExpr.Minus;

/**
 *  给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *  算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @author qiankun
 * @version 2021/12/27
 */
public class FindMedianSortedArraysV2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int all = length1 + length2;
        if (all % 2 == 1) {//单数
            int k = all / 2;
            return findKNum(nums1, nums2, k + 1);
        } else {//双数
            int k1 = all / 2, k2 = all / 2 - 1;
            return (findKNum(nums1, nums2, k1 + 1) + findKNum(nums1, nums2, k2 + 1)) / 2.0;
        }
    }

    public double findKNum(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            if (index1 >= length1) {
                return nums2[index2 + k - 1];
            }

            if (index2 >= length2) {
                return nums1[index1 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;

            int num1 = nums1[newIndex1];
            int num2 = nums2[newIndex2];
            if (num1 > num2) {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            } else {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
        }
    }

}
