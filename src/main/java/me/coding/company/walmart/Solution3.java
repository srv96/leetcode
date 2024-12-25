package me.coding.company.walmart;

import java.util.TreeSet;

class Solution3 {
    public int maximumProfit(int[] present, int[] future, int budget) {
        TreeSet<int[]> stockSequence = new TreeSet<>((o1, o2) -> {
            double gain1 = ((double) o1[1] - (double) o1[0]) / (double) o1[0];
            double gain2 = ((double) o2[1] - (double) o2[0]) / (double) o2[0];
            if (gain1 - gain2 > 0) return -1;
            else if (gain1 - gain2 < 0) return 1;
            else if (o1[0] - o2[0] > 0) return -1;
            else if (o1[0] - o2[0] < 0) return 1;
            else if (o1[0] == 0 && o2[0] == 0 && o1[1] - o2[1] > 0) return -1;
            else if (o1[0] == 0 && o2[0] == 0 && o1[1] - o2[1] < 0) return 1;
            else return o1[2] - o2[2];
        });
        int size = present.length;
        for (int i = 0; i < size; i++) {
            stockSequence.add(new int[]{present[i], future[i], i});
        }
        int profit = 0;
        while (budget >= 0 && !stockSequence.isEmpty()) {
            int[] pair = stockSequence.pollFirst();
            if (budget >= pair[0]) {
                profit += Math.max(0,pair[1] - pair[0]);
                budget -= pair[0];
            }
        }
        return profit;
    }
}
