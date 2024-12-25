package me.coding.company.visa;

class Solution1 {
    int[][] dp;

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return buy(prices, 0, true);
    }

    private int buy(int[] prices, int i, boolean buy) {
        if (i >= prices.length) return 0;
        if (buy) {
            if (dp[i][1] == -1) {
                int result = Math.max(
                        -1 * prices[i] + buy(prices, i + 1, false),
                        0 + buy(prices, i + 1, true)
                );
                dp[i][1] = result;
            }
            return dp[i][1];
        } else {
            if (dp[i][0] == -1) {
                int result = Math.max(
                        prices[i] + buy(prices, i + 2, true),
                        0 + buy(prices, i + 1, false)
                );
                dp[i][0] = result;
            }
            return dp[i][0];
        }
    }
}