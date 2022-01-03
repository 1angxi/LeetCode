package com.me.backtrace;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] res = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean has = search(board, word, 0, i, j, row, col, res);
                if (has) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int index, int i, int j, int row, int col, boolean[][] res) {
        if (index == word.length()) {//遍历完了
            return true;
        }

        if (i == row || j == col || i < 0 || j < 0 || res[i][j]) {
            return false;
        }

        if (board[i][j] == word.charAt(index)) {//相等
            res[i][j] = true;
            if (search(board, word, index + 1, i + 1, j, row, col, res)) return true;
            if (search(board, word, index + 1, i, j + 1, row, col, res)) return true;
            if (search(board, word, index + 1, i - 1, j, row, col, res)) return true;
            if (search(board, word, index + 1, i, j - 1, row, col, res)) return true;
            res[i][j] = false;
        }
        return false;
    }
}
