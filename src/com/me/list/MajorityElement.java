package com.me.list;

import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/29
 */
public class MajorityElement {

    /**
     * 用hash表计数。当计数大于nums.length /2，立即返回结果。
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }

        for (int i : nums) {
            if(map.get(i) > (nums.length /2)){
                return i;
            }
        }
        return 0;
    }

    /**
     * 投票算法。选一个候选人，初始票数是1。遍历后续数字，碰到不通数字票数减1，如果票数等于0则更新候选人。
     *
     * 核心原理在于，最多的元素大于一半，也就是其他任何数字碰到最多的元素都会被投票下去。最后只有最多的元素能保留到最后。
     */
    public int majorityElementV2(int[] nums) {
        int count = 0;
        int candi = 0;

        for (int num : nums) {
            if (count == 0) {
                candi = num;
            }

            count += ((candi == num) ? 1 : -1);
        }
        return candi;
    }

}
