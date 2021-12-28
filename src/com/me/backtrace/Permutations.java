package com.me.backtrace;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/28
 */
public class Permutations {

    /**
     * 诀窍是递归+回溯法；设置一个原始的数组，通过不断交换位置得到结果；结果深拷贝到总结果中；
     */
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        List<List<Integer>> all = new ArrayList<>();

        backtrack(nums.length, all, output, 0);

        return all;
    }

    public void backtrack(int n, List<List<Integer>> all, List<Integer> output, int beginIndex) {
        if (beginIndex == n) {
            all.add(new ArrayList<>(output));
            return;
        }


        for (int i = beginIndex; i < output.size(); i++) {
            Collections.swap(output, beginIndex, i);
            backtrack(n, all, output, beginIndex + 1);
            Collections.swap(output, beginIndex, i);
        }
    }
}
