package me.coding.leetcode.top150;

import java.util.*;

class Solution41 {
    public List<List<Integer>> combine(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> result = combination(visited, n, 1, k);
        return result;
    }

    private List<List<Integer>> combination(boolean[] visited, int n, int idx, int k) {
        if (k == 0) {
            return Arrays.asList(new ArrayList<>());
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = idx; i <= n - k + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                List<List<Integer>> subResult = combination(visited, n, i, k - 1);
                visited[i] = false;
                if (subResult.size() == 1 && subResult.get(0).size() == 0) {
                    List<Integer> row = subResult.get(0);
                    row.add(0, i);
                    subResult.set(0, row);
                } else {
                    int finalI = i;
                    subResult.forEach(res -> res.add(0, finalI));
                }
                result.addAll(subResult);
            }
        }
        return result;
    }
}
