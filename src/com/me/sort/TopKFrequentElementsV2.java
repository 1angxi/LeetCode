package com.me.sort;

import java.lang.reflect.Array;
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
public class TopKFrequentElementsV2 {
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

        qSort(mid, res, 0, 0, countMap.size()-1, k);

        return res;
    }

    public void qSort(List<int[]> mid, int[] res, int hasRes, int begin, int end, int k) {
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

        Collections.swap(mid, begin, l);

        //如何剪枝？右边界到右指针，如果小于k，说明都是结果，直接放入。左指针指向到左边界，如果小于n-k，说明左边界可以舍弃。
        //0-l l-end   0-3, 3-5  5个元素 求2
        if (end - l + 1 <= k) {
            int adNum = 0;
            for (int i = end; i >= l; i--) {
                res[hasRes++] = mid.get(i)[0];
                adNum++;
            }

            if (hasRes < res.length) {
                qSort(mid, res, hasRes, begin, l - 1, k - adNum);
            }
        } else {
            qSort(mid, res, hasRes, l+1, end, k);
        }
    }
}
