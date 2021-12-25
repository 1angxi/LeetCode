package com.me.string;

import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 *
 * @author qiankun
 * @version 2021/12/24
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) return 0;
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> hashSet = new HashSet<>();
            char cha = s.charAt(i);
            hashSet.add(cha);
            for (int j = i + 1; j < s.length(); j++) {
                char add = s.charAt(j);
                if (!hashSet.contains(add)) {
                    hashSet.add(add);
                } else {
                    break;
                }
            }
            max = Math.max(max, hashSet.size());
        }

        return max;
    }

    public static int lengthOfLongestSubstringV2(String s) {
        if (s == null || "".equals(s)) return 0;
        int max = 1;
        HashSet<Character> hashSet = new HashSet<>();

        int rk = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                hashSet.remove(s.charAt(i - 1));
            }

            while (rk + 1 < s.length() && !hashSet.contains(s.charAt(rk + 1))) {
                hashSet.add(s.charAt(rk + 1));
                rk++;
            }

            max = Math.max(max, rk - i + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
