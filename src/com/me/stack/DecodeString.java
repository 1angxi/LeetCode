package com.me.stack;

import java.util.LinkedList;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 *
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeString {

    /**
     * 诀窍是两个栈。。碰到]才处理新的字符串。算最里面的，重新压入栈
     */
    public String decodeString(String s) {
        LinkedList<String> strStack = new LinkedList<>();
        LinkedList<Integer> numStack = new LinkedList<>();
        int num = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {//数字
                num = (num * 10) + (c - '0');


            } else if (c == '[') {
                numStack.push(num);
                num = 0;


                if (str.length() > 0) {//可能存在前缀字符串
                    strStack.push(str.toString());
                    str = new StringBuilder();
                }

                strStack.push("[");

            } else if (c == ']') {
                while (!"[".equals(strStack.peek())) {
                    str.insert(0, strStack.pop());
                }

                String word = str.toString();
                str = new StringBuilder();

                strStack.pop();
                Integer time = numStack.poll();

                StringBuilder repeat = new StringBuilder();
                for (int t = 0; t < time; t++) {
                    repeat.append(word);
                }
                strStack.push(repeat.toString());
            } else {
                str.append(c);
            }
        }

        if(!strStack.isEmpty()){
            str.insert(0, strStack.pop());
        }

        StringBuilder res = new StringBuilder();
        while (!strStack.isEmpty()){
            res.insert(0, strStack.pop());
        }


        if (str.length() > 0) {
            res.append(str);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
    }
}
