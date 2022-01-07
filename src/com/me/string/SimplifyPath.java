package com.me.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * <p>
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * <p>
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simplify-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<StringBuilder> stack = new LinkedList<>();

        int i = 0;

        StringBuilder temp = new StringBuilder();
        while (i < path.length()) {

            char c = path.charAt(i);
            if (c == '/') {
                i++;
                while (i < path.length() && path.charAt(i) == '/') {
                    i++;
                }

                if (temp.length() > 0) {
                    stack.push(temp);
                    temp = new StringBuilder();
                }

            } else if (c == '.') {
                i++;
                temp.append(c);
                while (i < path.length() && path.charAt(i) != '/') {
                    temp.append(path.charAt(i));
                    i++;
                }

                if (temp.toString().equals("..") && stack.size() > 1) {
                    stack.pop();
                } else if (!temp.toString().equals(".") && !temp.toString().equals("..")) {
                    stack.push(temp);
                }
                temp = new StringBuilder();

            } else {
                temp.append(c);
                i++;
            }
        }
        if (temp.length() > 0) {
            stack.push(temp);
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop().toString());
            builder.insert(0, "/");
        }
        return builder.length() != 0 ? builder.toString() : "/";
    }
}
