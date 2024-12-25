package me.coding.company.microsoft;

import java.util.*;

class Solution5 {
    Map<Integer, Integer> memo;
    int maxLimit;

    public int minimumOperationsToMakeEqual(int x, int y) {
        memo = new HashMap<>();
        maxLimit = x + 11;
        return dfs(x, y);
    }

    public int dfs(int x, int y) {
        if (x == 0) return y;
        if (x > maxLimit) return Integer.MAX_VALUE;
        if (!memo.containsKey(x)) {
            if (x <= y) {
                memo.put(x, y - x);
            } else {
                int path1, path2, path3, path4;
                if (x % 11 != 0) {
                    int x_11 = x;
                    while (x_11 % 11 != 0) x_11++;
                    path1 = 1 + (x_11 - x) + dfs(x_11 / 11, y);
                } else path1 = 1 + dfs(x / 11, y);
                if (x % 5 != 0) {
                    int x_5 = x;
                    while (x_5 % 5 != 0) x_5++;
                    path2 = 1 + (x_5 - x) + dfs(x_5 / 5, y);
                } else path2 = 1 + dfs(x / 5, y);
                path3 = 1 + dfs(x - 1, y);
                memo.put(x, Math.min(path1, Math.min(path2, path3)));
            }
        }
        return memo.get(x);
    }
}
