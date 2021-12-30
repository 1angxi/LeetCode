package com.me.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfIslands {

    /**
     * 深度优先，用递归实现；广度遍历，用辅助空间实现
     */
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    ds(grid, i, j, row, col);
                }
            }
        }

        return num;
    }


    public void ds(char[][] grid, int i, int j, int row, int col) {
        if (i >= row || j >= col || i < 0 || j < 0) {
            return;
        }

        grid[i][j] = '0';

        if (i + 1 < row && grid[i + 1][j] == '1') {
            ds(grid, i + 1, j, row, col);
        }

        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            ds(grid, i - 1, j, row, col);
        }

        if (j + 1 < col && grid[i][j + 1] == '1') {
            ds(grid, i, j + 1, row, col);
        }

        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            ds(grid, i, j - 1, row, col);
        }
    }

    public int numIslandsV2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;


        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';

                    Queue<Integer> neighbors = new LinkedList<>();

                    //这里用了一个骚操作。用一个数字存储两个数字的内容。通过中间数字nc来做。（类似用*100000的操作。不过用nc更保险）
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }
}
