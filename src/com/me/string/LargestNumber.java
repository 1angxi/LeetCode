package com.me.string;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {

        String[] numStrs = new String[nums.length];

        for(int i =0;i<nums.length;i++){
            numStrs[i] = nums[i] + "";
        }

        Arrays.sort(numStrs, (x, y) -> {
            long x1 = Long.parseLong(x + y);
            long y1 = Long.parseLong(y + x);
            return (int) (y1 - x1); //倒序排
        });

        StringBuilder s= new StringBuilder();
        for(int i =0;i<numStrs.length;i++){
            s.append(numStrs[i]);
        }

        if(numStrs[0].equals("0")){
            return "0";
        }

        return s.toString();
    }
}
