package com.me.list;

import java.util.HashMap;

/**
 * @author qiankun
 * @version 2021/12/29
 */
public class MajorityElement {
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
