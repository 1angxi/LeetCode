package com.me.string;

import java.util.ArrayList;
import java.util.List;

/**
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
