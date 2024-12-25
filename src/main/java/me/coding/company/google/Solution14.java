package me.coding.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution14 {
    public List<Integer> findAnagrams(String s, String p) {
        int subSize = p.length(), size = s.length();
        if (size < subSize) return new ArrayList<>();
        int[] subStringMap = new int[26];
        int[] stringPartMap = new int[26];
        Arrays.fill(subStringMap, 0);
        Arrays.fill(stringPartMap, 0);
        for (int i = 0; i < subSize; i++) {
            subStringMap[p.charAt(i) - 'a']++;
            stringPartMap[s.charAt(i) - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = subSize; i <= size; i++) {
            if (isSame(subStringMap, stringPartMap)) result.add(i-subSize);
            if (i < size) {
                stringPartMap[s.charAt(i - subSize) - 'a']--;
                stringPartMap[s.charAt(i) - 'a']++;
            }
        }
        return result;
    }

    private boolean isSame(int[] subStringMap, int[] stringPartMap) {
        for (int i = 0; i < 26; i++) {
            if (stringPartMap[i] != subStringMap[i]) return false;
        }
        return true;
    }
}
