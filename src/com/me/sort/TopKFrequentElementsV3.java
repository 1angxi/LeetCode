package com.me.sort;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequentElementsV3 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.putIfAbsent(num, 0);
            countMap.put(num, countMap.get(num) + 1);
        }

        List<int[]> mid = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            mid.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] res = new int[k];

        qSort(mid, 0, mid.size() - 1);

        for (int i = 0; i < k; i++) {
            res[i] = mid.get(mid.size() - 1 - i)[0];
        }

        return res;
    }

    /**
     * 面试的时候直接写快排好了。剪枝调试时间过久
     */
    public void qSort(List<int[]> mid, int begin, int end) {
        if(begin > end){
            return;
        }

        //以第一个元素为轴(更好的办法是随机一个轴)
        int[] tag = mid.get(begin);

        int l = begin;
        int r = end;

        //从右指针开始跟轴比较，如果比轴小，跟轴的数据做替换。
        //接着从左指针开始跟轴比较，如果比轴大，跟右边界交换。
        //只要左指针比右指针大，就继续循环
        //最终把第一个元素跟左指针指向的地方做交换

        while (l < r) {
            while (l < r && mid.get(r)[1] >= tag[1]) {
                r--;
            }

            while (l < r && mid.get(l)[1] <= tag[1]) {
                l++;
            }

            if (l < r) {
                Collections.swap(mid, l, r);
            }
        }

        Collections.swap(mid, l, begin);

        qSort(mid, begin, l - 1);
        qSort(mid, l + 1, end);
    }
}
