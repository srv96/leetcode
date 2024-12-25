package me.coding.leetcode.top150;

import java.util.ArrayList;
import java.util.List;

class Solution40 {
    public List<List<Integer>> permute(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> result = parmutation(visited, n, k);
        return result;
    }

    private List<List<Integer>> parmutation(boolean[] visited, int n, int k) {
        if (k == 0) {
            List<Integer> row = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            result.add(row);
            return result;
        } else {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    List<List<Integer>> subResult = parmutation(visited, n, k - 1);
                    visited[i] = false;
                    int finalI = i;
                    subResult.forEach(row -> {
                        if (row.isEmpty()) row.add(finalI);
                        else row.add(0, finalI);
                    });

                    result.addAll(subResult);

                }
            }
            return result;
        }
    }
}
