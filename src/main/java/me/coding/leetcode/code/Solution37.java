package me.coding.leetcode.code;

import java.util.Arrays;

class Solution37 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int size = piles.length / 3;
        int result = 0;
        int idx = piles.length-2;
        for (int i = 0; i < size; i++) {
            result += piles[idx];
            idx-=2;
        }
        return result;
    }
}
