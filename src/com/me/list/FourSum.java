package com.me.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qiankun
 * @version 2021/12/24
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target1 = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int target2 = target1 - nums[j];
                int begin = j + 1;
                int end = nums.length - 1;
                while (begin < end) {
                    if (nums[begin] + nums[end] == target2) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                        begin++;
                        end--;
                        while (begin < end && nums[begin] == nums[begin - 1]) begin++;
                        while (begin < end && nums[end] == nums[end + 1]) end--;
                    } else if (nums[begin] + nums[end] < target2) {
                        begin++;
                    } else if (nums[begin] + nums[end] > target2) {
                        end--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
    }
}
