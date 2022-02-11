package com.me.greedy;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanJump {
    public boolean canJump(int[] nums) {


        int maxPos = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }

            /*
             * 最关键是这里。开头就是0，可能跳不出的。
             */
            if (maxPos == i) {
                break;
            }
        }

        return maxPos >= (nums.length - 1);
    }
}
