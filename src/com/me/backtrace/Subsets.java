package com.me.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        dfs(list, res, 0, nums);
        return list;
    }

    public void dfs(List<List<Integer>> list, List<Integer> res, int i, int[] nums) {
        if (i == nums.length) {
            return;
        }
        res.add(nums[i]);
        list.add(new ArrayList<>(res));

        dfs(list, res, i + 1, nums);
        res.remove(res.size() - 1);
        dfs(list, res, i + 1, nums);
    }
}
