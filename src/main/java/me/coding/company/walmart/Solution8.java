package me.coding.company.walmart;

import java.util.Hashtable;
import java.util.Map;

class Solution8 {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0;
        Map<Integer, Integer> occurrence = new Hashtable<>();
        int len = 0, maxLen = 0;
        while (r < fruits.length) {
            occurrence.put(fruits[r], occurrence.getOrDefault(fruits[r], 0) + 1);
            r++;
            len++;
            if (occurrence.size() > 2) {
                occurrence.put(fruits[l], occurrence.get(fruits[l]) - 1);
                if (occurrence.get(fruits[l]) == 0) occurrence.remove(fruits[l]);
                l++;
                len--;
                continue;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
