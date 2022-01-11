package com.me.sort;


import java.util.Arrays;

/**
 * 使用对排序找到第K大的元素
 */
public class HeapSort {

    public int findKthLargest(int[] nums, int k) {

        int n = nums.length - k + 1;

        //构建大根堆
        for (int i = (n - 1) / 2; i >= 0; i--) {//从首个非叶子节点开始（k-1）/2，自下往上构建大根堆
            adjust(nums, i, n);
        }

        //大根堆的头结点是最大值。每次根最大值比较，如果小于最大值，就把最大值替换掉
        for (int i = n; i < nums.length; i++) {
            if (nums[i] < nums[0]) {
                nums[0] = nums[i];
                adjust(nums, 0, n);//只有堆顶元素不对，因此只需从堆顶开始重新调整大根堆
            }
        }

        return nums[0];
    }

    public void buildHeap(int[] nums, int size) {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            adjust(nums, i, size);
        }

        for (int i = size - 1; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjust(nums, 0, i);
        }
    }

    /**
     * 构建大根堆
     */
    public void adjust(int[] nums, int i, int size) {
        //乘以2+1是左节点，乘以2+右是左节点
        int l = i * 2 + 1, r = i * 2 + 2;
        int largest = i;

        //找到数字最大的节点
        if (l < size && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < size && nums[r] > nums[largest]) {
            largest = r;
        }

        //如果最大值有变化，就替换根节点。如果子节点节点还有子节点，那就继续递归找子节点的最大值
        if (largest != i && largest < size) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            adjust(nums, largest, size);
        }
    }


    public static void main(String[] args) {
        int[] res = new int[]{3, 3, 2, 2, 4, 5, 2, 5};
        System.out.println(new HeapSort().findKthLargest(res, 1));
    }
}
