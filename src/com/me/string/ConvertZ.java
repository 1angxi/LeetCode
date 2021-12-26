package com.me.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/26
 */
public class ConvertZ {
    public String convert(String s, int numRows) {
        List<StringBuilder> res = new ArrayList<>();

        if (numRows <= 1) {
            return s;
        }

        int curRow = 0;

        boolean go = true;

        for (int i = 0; i < numRows; i++) {
            res.add(new StringBuilder());
        }

        for (int i = 0; i < s.length(); i++) {
            res.get(curRow).append(s.charAt(i));
            if (go) {
                curRow++;
            } else {
                curRow--;
            }

            if (curRow == numRows - 1) {
                go = false;
            }
            if (curRow == 0) {
                go = true;
            }
        }

        StringBuilder all = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            all.append(res.get(i));
        }
        return all.toString();
    }
}
