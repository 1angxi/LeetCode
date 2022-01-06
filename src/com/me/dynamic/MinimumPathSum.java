package com.me.dynamic;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumPathSum {
    public int minSum = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {

        /*
         * 方法是对的。但是会超时
         */
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] hasSee = new boolean[row][col];
        findMinPath(grid, row, col, 0, hasSee, 0, 0);
        return minSum;
    }

    public void findMinPath(int[][] grid, int row, int col, int sum, boolean[][] hasSee, int i, int j) {
        if (i == row - 1 && j == col - 1) {
            minSum = Math.min(sum + grid[i][j], minSum);
            return;
        }

        sum += grid[i][j];

        if(sum > minSum){
            return;
        }

        hasSee[i][j] = true;

        if (i + 1 < row && !hasSee[i + 1][j]) {
            findMinPath(grid, row, col, sum, hasSee, i + 1, j);
        }

        if (j + 1 < col && !hasSee[i][j + 1]) {
            findMinPath(grid, row, col, sum, hasSee, i, j + 1);
        }

        if (i > 0 && !hasSee[i - 1][j]) {
            findMinPath(grid, row, col, sum, hasSee, i - 1, j);
        }

        if (j > 0 && !hasSee[i][j - 1]) {
            findMinPath(grid, row, col, sum, hasSee, i, j - 1);
        }


        hasSee[i][j] = false;
    }
}
