package com.me.list;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] vals = new int[n][n];
        int all = n * n;
        int vertical = 0;
        int[][] addNum = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x = 0, y = 0;
        for (int i = 0; i < all; i++) {
            vals[x][y] = i+1;
            int nexRow = addNum[vertical][0] + x, nextCol = addNum[vertical][1] + y;
            if(nexRow <0 || nextCol <0 || nexRow >= n || nextCol >= n || vals[nexRow][nextCol] !=0){
                vertical = (vertical + 1) % 4;
            }

            x = addNum[vertical][0] + x;
            y = addNum[vertical][1] + y;
        }

        return vals;
    }

}
