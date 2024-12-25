package me.coding.leetcode.code;

import java.util.HashSet;
import java.util.Set;

class Solution50 {
    public int numberOfSpecialSubstrings(String s) {
        Set<Character> charSet = new HashSet<>();
        int l = 0, r = 0;
        int size = s.length();
        int count = 0;
        while (l < size || r < size) {
            if (r < size && !charSet.contains(s.charAt(r))) {
                charSet.add(s.charAt(r));
                count += (r - l) + 1;
                r++;
            } else {
                while (l < r && l < size && s.charAt(l) != s.charAt(r - 1)) {
                    charSet.remove(s.charAt(l));
                    l++;
                }
                l++;
                r = l;
            }
        }
        return count;
    }
}
