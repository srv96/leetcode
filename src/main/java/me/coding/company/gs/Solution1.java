package me.coding.company.gs;

import java.util.Hashtable;
import java.util.Map;

public class Solution1 {
    Map<Integer, Integer> memo = null;

    public int noOfWaysToDraTheGame(int totalScore) {
        int[] scores = new int[]{2, 4, 6};
        memo = new Hashtable<>();
        int result = getWays(scores, totalScore);
        return result;
    }

    private int getWays(int[] scores, int totalScore) {
        if (totalScore == 0) return 1;
        if (totalScore < 2) return 0;
        if (!memo.containsKey(totalScore)) {
            int count = 0, size = scores.length;
            for (int i = 0; i < size; i++) {
                count += getWays(scores, totalScore - scores[i]);
            }
            memo.put(totalScore, count);
        }
        return memo.get(totalScore);
    }
}
