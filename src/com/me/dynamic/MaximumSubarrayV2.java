package com.me.dynamic;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/27
 */
public class MaximumSubarrayV2 {
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            /*
             * 这个求得的是包含f(i)的最大子数组和；中间有可能存在不包含f(i)的，因此要有个max记录最大值
             */
            pre = Math.max(nums[i] + pre, nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
