package com.me.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/28
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.containsKey(num) ? (count.get(num) + 1) : 1);
        }

        for (int num : nums) {
            if(count.get(num) ==1) return num;
        }
        return 0;
    }

    /**
     * 用异或运算
     */
    public int singleNumberV2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res^=num;
        }
        return res;
    }
}
