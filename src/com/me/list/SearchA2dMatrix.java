package com.me.list;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchA2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        if (row == 0 || col == 0) return false;

        /*
         * 诀窍是找从右上角开始的规律
         */

        /*
         * 逐行使用二分查找也行
         */
        int j = col - 1, i = 0;
        while (j >= 0 && i <= row - 1) {
            int val = matrix[i][j];
            if(val == target){
                return true;
            } else if (val < target) {
                i++;
            } else if (val > target) {
                j--;
            }
        }
        return false;
    }
}
