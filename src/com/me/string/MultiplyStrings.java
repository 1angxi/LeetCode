package com.me.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/28
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        /*
         * 诀窍是要先懂字符串加法；
         */
        String ans = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            StringBuilder temp = new StringBuilder();
            for (int j = num1.length() - 1; j > i; j--) {
                temp.append("0");
            }

            int move = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int num = (n1 * n2 + move);
                move = num / 10;
                temp.append(num % 10);
            }
            if(move != 0){
                temp.append(move);
            }

            ans = addStrings(ans, temp.reverse().toString());
        }

        return ans;
    }


    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1, j = num2.length() - 1;

        StringBuilder num = new StringBuilder();
        int extra = 0;
        while (i >= 0 || j >= 0) {
            int add = 0;
            if (i >= 0) {
                add += (num1.charAt(i) - '0');
                i--;
            }

            if (j >= 0) {
                add += (num2.charAt(j) - '0');
                j--;
            }

            add += extra;

            if (add > 9) {
                extra = add / 10;
            } else {
                extra = 0;
            }
            num.append(add % 10);
        }

        if (extra != 0) {
            num.append(extra);
        }

        return num.reverse().toString();
    }


    /**
     * 诀窍：num1[i] * num2[j] 的位置是 i+j+1；通过证明可得结果长度小于等于m+n；遍历结束后处理数组中的值进位问题
     */
    public String multiplyV2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }

}
