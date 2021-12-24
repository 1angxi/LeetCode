package com.me.list;

import java.util.*;

/**
 * @author qiankun
 * @version 2021/12/24
 */
public class ThreeSum {
    /**
     * 复用twoSum题目的解法。但是会产生重复结果
     *
     * @param nums nums
     * @return List
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> temp = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int num = nums[j];
                if (temp.get(num) != null) {
                    List<Integer> one = new ArrayList<>();
                    one.add(nums[i]);
                    one.add(nums[j]);
                    one.add(-nums[i] - nums[j]);
                    res.add(one);
                }
                temp.put(target - num, i);
            }
        }
        return res;
    }

    /**
     * 不产生重复结果。
     *
     * @param nums nums
     * @return List
     */
    public List<List<Integer>> threeSumV2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length <= 2) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            if (nums[i] > 0) break;//后续都不成立
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                if (nums[begin] + nums[end] == target) {
                    res.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    begin++;
                    end--;
                    while (begin < end && nums[begin] == nums[begin - 1]) begin++;
                    while (begin < end && nums[end] == nums[end + 1]) end--;
                } else if (nums[begin] + nums[end] < target) {
                    begin++;
                } else if (nums[begin] + nums[end] > target) {
                    end--;
                }
            }
        }
        return res;
    }

}
