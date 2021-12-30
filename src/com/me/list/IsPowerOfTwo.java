package com.me.list;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
