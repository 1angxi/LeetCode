package com.me.dynamic;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/27
 */
public class ClimbStairs {
    /**
     * 诀窍是f(n) = f(n-1) + f(n-2)。刚好是斐波那契数列。
     * 因为前序的结果不重要。因此只需要用三个指针就好。
     */
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int p = 0, q = 1, r = 2;
        for (int i = 0; i < n; i++) {
            int temp = r;
            p = q;
            r = q + r;
            q = temp;
        }

        return p;
    }
}
