package me.coding.leetcode.top150;

import java.util.HashSet;
import java.util.Set;

class Solution57 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = Integer.MIN_VALUE;
        Set<Character> charSet = new HashSet<>();
        int size = s.length(), l = 0;
        int r = 0;
        if (size == 0) return 0;
        for (r = 0; r < size; r++) {
            if (!charSet.contains(s.charAt(r))) {
                charSet.add(s.charAt(r));
                maxLen = Math.max(maxLen, r - l + 1);
            } else {
                for (int i = l; i < r; i++) {
                    if (s.charAt(i) == s.charAt(r)) {
                        charSet.remove(s.charAt(l));
                        l++;
                        break;
                    }
                    charSet.remove(s.charAt(l));
                    l++;
                }
                charSet.add(s.charAt(r));
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        return maxLen;
    }
}