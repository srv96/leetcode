package me.coding.company.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution13 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = Arrays.stream(rolls).sum();
        int size = rolls.length;
        int missingSum = mean * (size + n) - sum;
        List<Integer> missing = new ArrayList<>();

        while (missingSum > n && n>0) {
            int used = Math.min(6, missingSum - (n-1));
            missing.add(used);;
            missingSum-=used;
            n--;
        }
        return missing.stream().mapToInt(Integer::intValue).toArray();
    }
}
