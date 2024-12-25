package me.coding.company.walmart;

import java.util.Arrays;

class Solution4 {
    int[][] memo;

    public int maximumProfit(int[] present, int[] future, int budget) {
        int[][] pair = new int[present.length][2];
        int size = present.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            pair[i][0] = present[i];
            pair[i][1] = future[i];
        }
        memo = new int[present.length + 1][budget + 1];
        for (int i = 0; i <= present.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        int result = findMax(pair, budget, 0, pair.length);
        return result;
    }

    private int findMax(int[][] pair, int budget, int idx, int size) {
        if (idx >= size) return 0;
        if (budget < 0) return 0;
        else {
            if (memo[idx][budget] == -1) {
                int ifYes = budget >= pair[idx][0] ? (pair[idx][1] - pair[idx][0]) + findMax(pair, budget - pair[idx][0], idx + 1, size) : Integer.MIN_VALUE;
                int ifNo = findMax(pair, budget, idx + 1, size);
                memo[idx][budget] = Math.max(ifYes, ifNo);
            }
            return memo[idx][budget];
        }
    }
}
