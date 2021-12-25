package com.me.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/24
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                countMap.put(num2 + num1, countMap.get(num2 + num1) != null ? countMap.get(num2 + num1) + 1 : 1);
            }
        }
        for (int num1 : nums3) {
            for (int num2 : nums4) {
                if (countMap.get(-num1 - num2) != null) {
                    count += countMap.get(-num1 - num2);
                }
            }
        }

        return count;

    }
}
