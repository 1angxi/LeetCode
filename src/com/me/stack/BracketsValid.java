package com.me.stack;

import sun.tools.jstat.Jstat;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/26
 */
public class BracketsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        List<Character> left = Arrays.asList('(', '{', '[');
        List<Character> right = Arrays.asList(')', '}', ']');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (left.contains(c)) {
                stack.push(c);
            } else if (right.contains(c) && stack.size() > 0 && stack.peek() == left.get(right.indexOf(c))) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}
