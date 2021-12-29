package com.me.list;

/**
 * @author qiankun
 * @version 2021/12/29
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        int z = 1;
        do {
            if (n == z) return true;
            if (n > z) {
                z = z * 2;
            }
        } while (n >= z && z > 0);
        return false;
    }

    /**
     * 诀窍是，0010000这种二进制减1，求&刚好是0
     */
    public boolean isPowerOfTwoV2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * 诀窍是，负数二进制表示是取反+1。 0001000 负数是 1111000。求&刚好是n自己。
     */
    public boolean isPowerOfTwoV3(int n) {
        return n > 0 && (n & -n) == n;
    }

}
