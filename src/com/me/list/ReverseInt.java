package com.me.list;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * @author qiankun
 * @version 2021/12/26
 */
public class ReverseInt {
    public int reverse(int x) {
        if (x == 0) return 0;

        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + (x % 10);
            x = x / 10;
        }

        return res;
    }
}
