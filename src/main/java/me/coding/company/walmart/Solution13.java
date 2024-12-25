package me.coding.company.walmart;

import java.util.Arrays;

class Solution13 {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPileSize = Arrays.stream(piles).max().getAsInt();
        int minK = 1;
        int maxK = maxPileSize;
        int avgK = 1;
        while (minK <= maxK) {
            avgK = (minK + maxK) / 2;
            int time = countTime(piles, avgK);
            if (time <= h) maxK = avgK - 1;
            else minK = avgK + 1;
        }
        return minK;
    }

    private int countTime(int[] piles, int k) {
        int totalPiles = piles.length;
        int totalTime = 0;
        for (int i = 0; i < totalPiles; i++) {
            totalTime += Math.ceil((double) piles[i] / (double) k);
        }
        return totalTime;
    }
}