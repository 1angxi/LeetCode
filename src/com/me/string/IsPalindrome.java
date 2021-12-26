package com.me.string;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/26
 */
public class IsPalindrome {

    /**
     * 1.为了防止溢出。提取一半的数字。
     * 2.判断退出条件，看大小是不是反转了
     */
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int orgNum = x;
        int addNum = 0;
        while (orgNum > addNum) {
            addNum = (addNum * 10) + (orgNum % 10);
            orgNum = orgNum / 10;
        }

        if (addNum == orgNum || (addNum / 10) == orgNum) {
            return true;
        }
        return false;
    }
}
