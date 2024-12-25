package me.coding.company.walmart;

import java.util.Arrays;

class Solution10 {
    int[][] dp;

    public int change(int amount, int[] coins) {
        dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return change(coins, coins.length - 1, amount);
    }

    private int change(int[] coins, int i, int amount) {
        if (i < 0) return 0;
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (dp[amount][i] != -1) return dp[amount][i];
        int notTake = change(coins, i - 1, amount);
        int take = change(coins, i, amount - coins[i]);
        int total = take + notTake;
        dp[amount][i] = total;
        return dp[amount][i];
    }
}
