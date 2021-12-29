package com.me.string;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/29
 */
public class ReverseWords {

    /**
     * 模拟整个流程
     */
    public String reverseWords(String s) {
        int i = 0;

        StringBuilder temp = new StringBuilder();
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }

            int tar = j + 1;
            j--;

            while (j >= i) {
                temp.append(s.charAt(j));
                j--;
            }
            if (tar < s.length()) {
                temp.append(" ");
                i = tar;
            } else {
                break;
            }
        }
        return temp.toString();
    }
}
