package com.me.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qiankun
 * @version 2021/12/28
 */
public class SpiralOrder {

    /**
     * 使用辅助空间存储已经访问过的数据；
     * 分别定义4个方向如何处理i和j。当碰到同方向已经访问过了，通过取模改变方向；
     * 处理数据达到row*columns是结束条件
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        //i j 代表当前访问的数字
        //判断当前方向。定义0向右，1向下，2向左，3向上。单碰到下个元素已经访问，方向+1。

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int size = rows * columns;
        int direct = 0;
        int num = 0;
        List<Integer> number = new ArrayList<>();
        int[][] addNum = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int i = 0, j = 0;

        while (num < size) {
            number.add(matrix[i][j]);
            visited[i][j] = true;

            int nextI = addNum[direct][0] + i;
            int nextJ = addNum[direct][1] + j;
            if (nextI < 0 || nextJ < 0 || nextI >= rows || nextJ >= columns || visited[nextI][nextJ]) {
                direct = (direct + 1) % 4;
            }
            i += addNum[direct][0];
            j += addNum[direct][1];

            num++;
        }
        return number;
    }


    /**
     * 定义4个变量，代表矩阵的上下左右四个点。
     * 4个for循环处理每一层。处理一层之后改变4个点。
     */
    public List<Integer> spiralOrderV2(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

}
