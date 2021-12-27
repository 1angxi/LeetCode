package com.me.list;

/**
 * @author qiankun
 * @version 2021/12/27
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(area, maxArea);

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }
}
