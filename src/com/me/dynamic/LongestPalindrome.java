package com.me.dynamic;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/27
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {

        int length = s.length();
        if (length <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[length][length];

        /*
         * 种子数据。动态规划的初始是长度为1的。
         */
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;
        int end = 0;

        /*
         * 逐步扩大长度，找到答案。因此循环是用长度来做。
         */
        for (int l = 2; l <= length; l++) {
            for (int i = 0; i < length; i++) {
                int j = i + l - 1;
                if (j >= length) {
                    break;
                }

                char c1 = s.charAt(i);
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    //差距为1 和 2，且左右字符相等。比如aa和aba。也属于初始种子数据。
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                    end = j;
                }
            }
        }

        //左开右闭。记得+1
        return s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
