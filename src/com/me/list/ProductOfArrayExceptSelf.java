package com.me.list;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];


        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                l[i] = 1;
            } else {
                l[i] = l[i - 1] * nums[i - 1];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                r[i] = 1;
            } else {
                r[i] = r[i + 1] * nums[i + 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            l[i] = l[i] * r[i];
        }

        return l;
    }

    public int[] productExceptSelfV2(int[] nums) {
        int[] l = new int[nums.length];


        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                l[i] = 1;
            } else {
                l[i] = l[i - 1] * nums[i - 1];
            }
        }

        int p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                p = 1;
            } else {
                p = p * nums[i + 1];
            }

            l[i] = l[i] * p;

        }

        return l;
    }
}
