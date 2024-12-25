package me.coding.company.google;

import java.util.Arrays;

class Solution13 {
    public boolean checkInclusion(String s1, String s2) {
        int subSize = s1.length(), size = s2.length();
        if (size < subSize) return false;
        int[] subStringMap = new int[26];
        int[] stringPartMap = new int[26];
        Arrays.fill(subStringMap, 0);
        Arrays.fill(stringPartMap, 0);
        for (int i = 0; i < subSize; i++) {
            subStringMap[s1.charAt(i) - 'a']++;
            stringPartMap[s2.charAt(i) - 'a']++;
        }

        for (int i = subSize; i <= size; i++) {
            if (isSame(subStringMap, stringPartMap)) return true;
            else if (i < size) {
                stringPartMap[s2.charAt(i - subSize) - 'a']--;
                stringPartMap[s2.charAt(i) - 'a']++;
            }
        }
        return false;
    }

    private boolean isSame(int[] subStringMap, int[] stringPartMap) {
        for (int i = 0; i < 26; i++) {
            if (stringPartMap[i] != subStringMap[i]) return false;
        }
        return true;
    }
}
