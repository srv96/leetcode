package me.coding.company.google;

import java.util.Arrays;

class Solution21 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!rightRow(board, i)) return false;
            if (!rightColumn(board, i)) return false;
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!rightMiniSudoku(board, i, j)) return false;
            }
        }
        return true;
    }

    private boolean rightMiniSudoku(char[][] board, int i1, int j1) {
        int[] freq = new int[10];
        Arrays.fill(freq, 0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i1 + i][j1 + j] != '.') freq[board[i1 + i][j1 + j] - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 1) return false;
        }
        return true;
    }

    boolean rightRow(char[][] board, int idx) {
        int[] freq = new int[10];
        Arrays.fill(freq, 0);
        for (int i = 0; i < 9; i++) {
            if (board[idx][i] != '.') freq[board[idx][i] - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 1) return false;
        }
        return true;
    }

    boolean rightColumn(char[][] board, int idx) {
        int[] freq = new int[10];
        Arrays.fill(freq, 0);
        for (int i = 0; i < 9; i++) {
            if (board[i][idx] != '.') freq[board[i][idx] - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 1) return false;
        }
        return true;
    }
}
