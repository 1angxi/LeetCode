package com.me.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeIntervals {
    /**
     * 诀窍是对第一个数字排序，如果可以合并数字对必然连续，因此逐步合并数字即可。
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (i == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(new int[]{l, r});
            } else {
                res.get(res.size() - 1)[1] = Math.max(r, res.get(res.size() - 1)[1]);
            }
        }


        return res.toArray(new int[res.size()][2]);
    }
}
