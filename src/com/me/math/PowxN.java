package com.me.math;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PowxN {
    public double myPow(double x, int n) {
        int z = Math.abs(n);
        double y = calPow(x, z);

        return n >= 0 ? y : 1 / y;
    }

    public double calPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double num = calPow(x, n / 2);
        return n % 2 == 0 ? num * num : num * num * x;
    }



}
