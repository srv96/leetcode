package me.coding.leetcode.code;

import me.coding.ds.tree.narray.Trie;

import java.util.*;

class Solution47 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie(null, false);
        for (String word : words) {
            trie.putString(word);
        }
        Set<String> result = new HashSet<>();
        findWords(board, result, trie);
        return new ArrayList<>(result);
    }

    private void findWords(char[][] board, Set<String> result, Trie trie) {
        int row = board.length;
        int col = board[0].length;
        if (trie == null) return;
        Trie[] children = trie.children;
        boolean[][] visited = new boolean[row][col];
        for (boolean[] r : visited) {
            Arrays.fill(r, false);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (children[board[i][j] - 'a'] != null) {
                    findWords(board, i, j, row, col, result, children[board[i][j] - 'a'], visited);
                }
            }
        }
    }

    private void findWords(char[][] board, int i, int j, int row, int col, Set<String> result, Trie trie, boolean[][] visited) {
        if (!isValidPosition(i, j, row, col) || visited[i][j]) return;
        else {
            if (trie == null) return;
            if (trie.isWord) result.add(trie.word);
            Trie[] children = trie.children;
            visited[i][j] = true;
            if (isValidPosition(i - 1, j, row, col))
                findWords(board, i - 1, j, row, col, result, children[board[i - 1][j] - 'a'], visited);
            if (isValidPosition(i, j - 1, row, col))
                findWords(board, i, j - 1, row, col, result, children[board[i][j - 1] - 'a'], visited);
            if (isValidPosition(i, j + 1, row, col))
                findWords(board, i, j + 1, row, col, result, children[board[i][j + 1] - 'a'], visited);
            if (isValidPosition(i + 1, j, row, col))
                findWords(board, i + 1, j, row, col, result, children[board[i + 1][j] - 'a'], visited);
            visited[i][j] = false;
        }
    }

    private boolean isValidPosition(int i, int j, int row, int col) {
        if (i >= 0 && i < row && j >= 0 && j < col) return true;
        else return false;
    }
}
