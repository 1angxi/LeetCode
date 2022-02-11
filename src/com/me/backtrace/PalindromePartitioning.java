package com.me.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> all = new ArrayList();
        List<String> res = new ArrayList();

        backTrace(all, res, s, 0, 0);

        return all;
    }

    public void backTrace(List<List<String>> all, List<String> res, String s, int i, int j){
        if(j == s.length() - 1){
            if(isPar(s, i, j)){
                res.add(s.substring(i, j+1));
                all.add(new ArrayList(res));
                res.remove(res.size() -1);
            }
            return;
        }

        if(isPar(s, i,j)){
            res.add(s.substring(i,j+1));
            backTrace(all, res, s, j+1, j+1);
            res.remove(res.size() -1);
        }

        backTrace(all, res, s, i, j+1);
    }


    public boolean isPar(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
