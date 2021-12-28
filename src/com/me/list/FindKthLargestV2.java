package com.me.list;

import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/28
 */
public class FindKthLargestV2 {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }

    /**
     * 1.用随机数优化快排
     * 2.减少处理的分支
     */
    public void quickSort(int[] arr, int low, int high, int k) {
        int i, j, temp;

        if (low >= high) {
            return;
        }

        i = low;
        j = high;

        //随机数优化快排
        int rand = random.nextInt(high - low);
        temp = arr[low + rand];
        int numLow = arr[low];
        arr[low] = temp;
        arr[low + rand] = numLow;

        while (i != j) {
            while (temp <= arr[j] && i < j) {
                j++;
            }

            while (temp >= arr[i] && i < j) {
                i++;
            }

            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }

        arr[low] = arr[i];
        arr[i] = temp;

        if (i == k) {//找到了
            return;
        }

        //减少处理的分支
        if (k > i) {
            quickSort(arr, i + 1, high, k);
        } else {
            quickSort(arr, low, i - 1, k);
        }
    }
}
