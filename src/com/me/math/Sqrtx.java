package com.me.math;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 4
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sqrtx {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;

        while (l <= r) {
            int mid = (r - l) / 2 + l; //求mid要注意
            if (mid * mid == x) {
                return mid;
            }
            if ((long) mid * mid > x) {//考虑数据溢出
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }
}
