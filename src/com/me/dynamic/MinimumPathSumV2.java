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
public class MinimumPathSumV2 {
    public int minPathSum(int[][] grid) {

        /*
         * 诀窍是动态规划；直接看图容易被误导，dp[i][j]是不存在绕路的，原因是i,j就是子图的长宽了。
         */
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0 && j != 0) {
                    dp[i][j] = dp[0][j - 1] + grid[i][j];
                }

                if (i != 0 && j == 0) {
                    dp[i][j] = dp[i - 1][0] + grid[i][j];
                }

                if (i != 0 && j != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
