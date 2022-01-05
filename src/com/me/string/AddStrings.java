package com.me.string;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 * 示例 1：
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/28
 */
public class AddStrings {

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

        //记得最后进位
        if(extra != 0){
            num.append(extra);
        }

        return num.reverse().toString();
    }
}
