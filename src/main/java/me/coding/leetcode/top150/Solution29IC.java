package me.coding.leetcode.top150;

class Solution29IC {
    public void gameOfLife(int[][] board) {
        int rowNum = board.length;
        int colNum = board[0].length;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                int count = countNeighbour(board, i, j, rowNum, colNum);
            }
        }
    }

    private int countNeighbour(int[][] board, int i, int j, int rowNum, int colNum) {
        if (i - 1 >= 0 && i + 1 < rowNum && j - 1 >= 0 && j + 1 < colNum) {
            return board[i][j - 1] >= 1 ? 1 : 0 + board[i + 1][j - 1] >= 1 ? 1 : 0 + board[i + 1][j] >= 1 ? 1 : 0 + board[i + 1][j + 1] >= 1 ? 1 : 0 + board[i][j + 1] >= 1 ? 1 : 0 + board[i + 1][j - 1] >= 1 ? 1 : 0 + board[i][j - 1] >= 1 ? 1 : 0 + board[i - 1][j - 1] >= 1 ? 1 : 0;
        }
        if (i - 1 < 0 && i + 1 < rowNum && j - 1 < 0 && j + 1 < colNum) {
            return board[i + 1][j] >= 1 ? 1 : 0 + board[i][j + 1] >= 1 ? 1 : 0 + board[i + 1][j + 1] >= 1 ? 1 : 0;
        }
        if (i - 1 < 0 && i + 1 < colNum && j - 1 >= 0 && j + 1 < colNum) {
            return board[i][j - 1] >= 1 ? 1 : 0 + board[i + 1][j - 1] >= 1 ? 1 : 0 + board[i + 1][j] >= 1 ? 1 : 0 + board[i][j + 1] >= 1 ? 1 : 0 + board[i + 1][j + 1] >= 1 ? 1 : 0;
        }
        if (i - 1 < 0 && i + 1 < colNum && j - 1 < 0 && j + 1 >= colNum) {
            return board[i][j - 1] >= 1 ? 1 : 0 + board[i + 1][j - 1] >= 1 ? 1 : 0 + board[i + 1][j] >= 1 ? 1 : 0;
        }
        if (i - 1 >= 0 && i + 1 < rowNum && j - 1 < 0 && j + 1 < colNum) {
            return board[i + 1][j] >= 1 ? 1 : 0 + board[i + 1][j + 1] >= 1 ? 1 : 0 + board[i][j + 1] >= 1 ? 1 : 0 + board[i - 1][j + 1] >= 1 ? 1 : 0 + board[i - 1][j] >= 1 ? 1 : 0;
        }
        if (i - 1 >= 0 && i + 1 < rowNum && j - 1 >= 0 && j + 1 >= colNum) {
            return board[i - 1][j - 1] >= 1 ? 1 : 0 + board[i][j - 1] >= 1 ? 1 : 0 + board[i + 1][j - 1] >= 1 ? 1 : 0 + board[i + 1][j] >= 1 ? 1 : 0 + board[i - 1][j] >= 1 ? 1 : 0;
        }
        if (i - 1 < 0 && i + 1 >= rowNum && j - 1 < 0 && j + 1 < colNum) {
            return board[i][j + 1] >= 1 ? 1 : 0 + board[i - 1][j + 1] >= 1 ? 1 : 0 + board[i - 1][j] >= 1 ? 1 : 0;
        }
        if (i - 1 >= 0 && i + 1 >= rowNum && j - 1 >= 0 && j + 1 < colNum) {
            return board[i][j + 1] >= 1 ? 1 : 0 + board[i - 1][j + 1] >= 1 ? 1 : 0 + board[i - 1][j] >= 1 ? 1 : 0 + board[i - 1][j - 1] >= 1 ? 1 : 0 + board[i][j - 1] >= 1 ? 1 : 0;
        }
        if (i - 1 >= 0 && i + 1 >= rowNum && j - 1 >= 0 && j + 1 >= colNum) {
            return board[i - 1][j] >= 1 ? 1 : 0 + board[i - 1][j - 1] >= 1 ? 1 : 0 + board[i][j - 1] >= 1 ? 1 : 0;
        }
        return Integer.MIN_VALUE;
    }
}