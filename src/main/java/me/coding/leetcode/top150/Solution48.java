package me.coding.leetcode.top150;

import java.util.Arrays;
import java.util.Collections;

class Solution48 {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        coins = Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int result = minCoin(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int minCoin(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (memo[amount] != -1) return memo[amount];
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = minCoin(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, ans + 1);
            }
        }
        return memo[amount] = minCoins;
    }
}
