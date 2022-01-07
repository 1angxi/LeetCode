package com.me.backtrace;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *  
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationV2 {
    public String[] permutation(String s) {
        Set<String> res = new HashSet<>();
        boolean[] hasSearch = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dfs(s, hasSearch, i, new StringBuilder(), res);
        }

        String[] arr = new String[res.size()];
        return res.toArray(arr);
    }

    /**
     * 一种优化办法，i可以改为字符串当前长度。
     */
    public void dfs(String s, boolean[] hasSearch, int i, StringBuilder nowStr, Set<String> res) {
        if (nowStr.length() + 1 == s.length()) {
            nowStr.append(s.charAt(i));
            res.add(nowStr.toString());
            nowStr.deleteCharAt(nowStr.length() - 1);
            return;
        }

        hasSearch[i] = true;
        nowStr.append(s.charAt(i));
        for (int j = 0; j < s.length(); j++) {
            if (hasSearch[j]) continue;
            dfs(s, hasSearch, j, nowStr, res);
        }
        nowStr.deleteCharAt(nowStr.length() - 1);
        hasSearch[i] = false;
    }
}
