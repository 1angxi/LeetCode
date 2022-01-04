package com.me.dynamic;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] temp = new int[amount + 1];
        Arrays.fill(temp, amount + 1);
        temp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    /*
                     * 诀窍是动态规划，找到状态转移函数。 初始值是temp[0]=0。
                     */
                    temp[i] = Math.min(temp[i - coin] + 1, temp[i]);
                }
            }
        }

        //对结果的特殊处理。不是合法结果，返回-1。
        return temp[amount] > amount ? -1 : temp[amount];
    }
}
