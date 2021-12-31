package com.me.list;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        int closeNum = 1000000;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    return target;
                }

                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(sum - target) < Math.abs(closeNum - target)) {
                    closeNum = sum;
                }

                if (sum > target) {
                    k--;
                } else {
                    i++;
                }
            }
        }
        return closeNum;
    }
}
