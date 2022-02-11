package com.me.dynamic;

/**
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 *
 * "1AB2345CD","12345EF"
 * "2345"
 *
 * 链接：https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=117
 */
public class LCS {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        int n = str1.length();
        int m = str2.length();

        if(n==0 || m==0){
            return "";
        }

        int [][] dp = new int[n][m];
        int maxLen = 0;
        String maxStr= "";

        for(int i= 0;i<n;i++){
            for(int j=0;j<m;j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    if(i == 0 || j == 0){
                        /*
                         * 初始数据
                         */
                        dp[i][j] = 1;
                    } else {
                        /*
                         * 动态规划的转移方程1
                         */
                        dp[i][j] =  dp[i-1][j-1] + 1;
                    }

                    if(dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        maxStr=str1.substring(i-maxLen+1,i+1);
                    }
                } else {
                    /*
                     * 动态规划的转移方程2
                     */
                    dp[i][j] = 0;
                }
            }
        }

        return maxStr;
    }
}
