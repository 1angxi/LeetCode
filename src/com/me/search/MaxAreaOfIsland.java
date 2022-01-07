package com.me.search;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] has = new boolean[row][col];
        int maxNum = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!has[i][j]) {
                    int num = searchNum(grid, row, col, i, j, has);
                    maxNum = Math.max(num, maxNum);
                }
            }
        }

        return maxNum;
    }

    public int searchNum(int[][] grid, int row, int col, int i, int j, boolean[][] has) {
        if (grid[i][j] == 0) {
            return 0;
        }

        int num = 1;

        has[i][j] = true;

        if (i > 0 && !has[i - 1][j]) {
            num += searchNum(grid, row, col, i - 1, j, has);
        }

        if (j > 0 && !has[i][j - 1]) {
            num += searchNum(grid, row, col, i, j - 1, has);
        }

        if (i < row - 1 && !has[i + 1][j]) {
            num += searchNum(grid, row, col, i + 1, j, has);
        }

        if (j < col - 1 && !has[i][j + 1]) {
            num += searchNum(grid, row, col, i, j + 1, has);
        }

        return num;
    }
}
