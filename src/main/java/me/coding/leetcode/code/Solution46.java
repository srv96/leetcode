package me.coding.leetcode.code;

class Solution46 {
    private int[] getLPS(String substring) {
        int[] lps = new int[substring.length()];
        lps[0] = 0;
        int prevLPS = 0, i = 1;
        int size = substring.length();
        while (i < size) {
            if (substring.charAt(i) == substring.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                prevLPS += 1;
                i += 1;
            } else if (prevLPS == 0) {
                lps[i] = 0;
                i += 1;
            } else {
                prevLPS = lps[prevLPS - 1];
            }
        }
        return lps;
    }
    public String longestPrefix(String s) {
        int[] lps = getLPS(s);
        return s.substring(0,lps[lps.length-1]);
    }
}

