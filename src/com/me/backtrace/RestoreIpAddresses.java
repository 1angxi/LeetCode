package com.me.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddresses {

    /**
     * 诀窍是回溯法。递归函数透传 num 代表是第0-3个数字。index代表当前还未使用的字符串下标。
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        dfs(res, builder, 0, 0, s);

        return res;
    }

    public void dfs(List<String> res, StringBuilder builder, int num, int index, String s) {
        if (index >= s.length()) {
            return;
        }

        if (num == 3) {
            if (s.length() - index > 3) {//长度超标
                return;
            }

            String last = s.substring(index, s.length());
            if (isValidNum(last)) {
                builder.append(".").append(last);
                res.add(builder.toString());
                builder.delete(builder.length() - (last.length() + 1), builder.length());
            }

            return;
        }

        for (int i = 1; i <= 3; i++) {
            if(index+i > s.length()) return;

            String last = s.substring(index, index + i);
            if (isValidNum(last)) {
                if (num != 0) builder.append(".");
                builder.append(last);

                dfs(res, builder, num+1, index + i, s);

                if (num != 0) {
                    builder.delete(builder.length() - (last.length() + 1), builder.length());
                } else {
                    builder.delete(builder.length() - (last.length()), builder.length());
                }
            }
        }
    }

    public boolean isValidNum(String num) {
        int real = 0;
        for (int i = 0; i < num.length(); i++) {
            int one = num.charAt(i) - '0';
            if (one == 0 && i == 0 && num.length() > 1) {
                return false;
            }
            real = real * 10 + one;
        }

        return real >= 0 && real <= 255;
    }
}
