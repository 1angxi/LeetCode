package com.me.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/26
 */
public class MyAtoi {

    public int myAtoi(String s) {
        List<List<String>> stats = new ArrayList<>();
        stats.add(Arrays.asList("sign", "end", "end", "end"));//sign status
        stats.add(Arrays.asList("addNum", "addNum", "end", "addNum"));//number status
        stats.add(Arrays.asList("start", "end", "end", "end"));//white status
        stats.add(Arrays.asList("addNum", "addNum", "end", "addNum"));//zero status
        stats.add(Arrays.asList("end", "end", "end", "end"));//other status

        Integer status = 0;
        String statusStr = "";

        MiddleRes middleRes = new MiddleRes();
        middleRes.sign = 1;
        middleRes.res = 0L;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);


            if (c == '-' || c == '+') {
                statusStr = stats.get(0).get(status);
            } else if (Character.isDigit(c)) {
                statusStr = stats.get(1).get(status);
            } else if (c == ' ') {
                statusStr = stats.get(2).get(status);
            } else if (c == '0') {
                statusStr = stats.get(3).get(status);
            } else {
                statusStr = stats.get(4).get(status);
            }

            status = dealStatus(middleRes, c, statusStr);

            if (status == 2) {
                break;
            }
        }

        return (int)(middleRes.res * (long)middleRes.sign);

    }

    public int dealStatus(MiddleRes middleRes, char c, String statusStr) {
        if (statusStr.equals("addNum")) {
            middleRes.res = middleRes.res * 10 + c - '0';
            middleRes.res = middleRes.sign == 1 ? Math.min(middleRes.res, (long) Integer.MAX_VALUE) : Math.min(middleRes.res, -(long) Integer.MIN_VALUE);
            return 1;
        }

        if (statusStr.equals("sign") && c == '-') {
            middleRes.sign = -1;
            return 3;
        }

        if (statusStr.equals("sign") && c == '+') {
            middleRes.sign = 1;
            return 3;
        }

        if (statusStr.equals("start")) {
            return 0;
        }

        return 2;
    }


    public class MiddleRes{
        Integer sign;
        Long res;
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("+1"));
    }
}
