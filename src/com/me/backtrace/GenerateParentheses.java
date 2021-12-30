package com.me.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backTrace(res, builder, 0, 0, n);
        return res;
    }

    public void backTrace(List<String> res, StringBuilder builder, int left, int right, int n) {
        if (builder.length() == n * 2) {
            res.add(builder.toString());
            return;
        }

        if(left < n){
            builder.append("(");
            backTrace(res, builder, left+1, right, n);
            builder.deleteCharAt(builder.length() - 1);
        }

        if(right < left){
            builder.append(")");
            backTrace(res, builder, left, right+1, n);
            builder.deleteCharAt(builder.length() - 1);
        }

    }
}
