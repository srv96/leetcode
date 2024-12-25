package me.coding.company.visa;

import java.util.HashMap;
import java.util.Map;

class Solution5 {
    public boolean canArrange(int[] arr, int k) {
        int size = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < size; i++) {
            mp.put(Math.abs(arr[i] % k), mp.getOrDefault(Math.abs(arr[i] % k), 0) + (arr[i] == 0 ? 1 : (arr[i] / Math.abs(arr[i]))));
        }
        int checkLimit = (int) Math.ceil((double) k / (double) 2);
        if (mp.getOrDefault(0, 0) % 2 != 0) return false;
        for (int i = 1; i < checkLimit; i++) {
            if (i == k - i && mp.getOrDefault(i, 0) % 2 != 0) return false;
            if (mp.getOrDefault(i, 0) != mp.getOrDefault(k - i, 0)) return false;
        }
        return true;
    }
}
