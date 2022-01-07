package com.me.string;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        List<StringBuilder> strings = new ArrayList<>();

        if (numRows == 1) {
            return s;
        }

        for (int i = 0; i < numRows; i++) {
            strings.add(new StringBuilder());
        }

        boolean go = true;
        int i = 0;
        for (char c : s.toCharArray()) {
            strings.get(i).append(c);
            if (go) {
                i++;
                if (i == numRows - 1) {
                    go = false;
                }
            } else {
                i--;
                if (i == 0) {
                    go = true;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int z = 0; z < numRows; z++) {
            res.append(strings.get(z));
        }

        return res.toString();
    }
}
