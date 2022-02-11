package com.me.dynamic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordBreak {
    /*
     * 初始值和状态转移方程：
     * dp[0] = 0;
     * dp[i]  = dp[j] + check(s[j,i]);
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        /*
         * 字符串从1开始。0代表字符串是0的结果。
         */
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < s.length() + 1 ; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
