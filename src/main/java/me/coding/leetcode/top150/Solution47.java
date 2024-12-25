package me.coding.leetcode.top150;

import java.util.Arrays;

class Solution47 {
    int[][] memo;

    public boolean validate(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int[] charCount = new int[26];
        for (char c : s1.toCharArray()) charCount[c - 'a']++;
        for (char c : s2.toCharArray()) charCount[c - 'a']++;
        for (char c : s3.toCharArray()){
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) return false;
        }
        return true;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (!validate(s1, s2, s3)) return false;

        int s1Size = s1.length();
        int s2Size = s2.length();
        memo = new int[s1Size + 1][s2Size + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        memo[s1Size][s2Size] = 1;

        boolean result = checkInterLeave(s1, s2, s3, 0, 0, s1Size, s2Size);
        return result;
    }

    private boolean checkInterLeave(String s1, String s2, String s3, int idx1, int idx2, int s1Size, int s2Size) {
        if (memo[idx1][idx2] != -1) return memo[idx1][idx2] == 1 ? true : false;

        if (idx1 < s1Size  && idx2 < s2Size  && s1.charAt(idx1) == s3.charAt(idx1 + idx2) && s2.charAt(idx2) == s3.charAt(idx1 + idx2)) {
            boolean result = checkInterLeave(s1, s2, s3, idx1 + 1, idx2, s1Size, s2Size) ||
                    checkInterLeave(s1, s2, s3, idx1, idx2 + 1, s1Size, s2Size);
            memo[idx1][idx2] = result ? 1 : 0;
            return result;
        }
        if (idx1 < s1Size && s1.charAt(idx1) == s3.charAt(idx1 + idx2)) {
            boolean result = checkInterLeave(s1, s2, s3, idx1 + 1, idx2, s1Size, s2Size);
            memo[idx1][idx2] = result ? 1 : 0;
            return result;
        }
        if (idx2 < s2Size && s2.charAt(idx2) == s3.charAt(idx1 + idx2)) {
            boolean result = checkInterLeave(s1, s2, s3, idx1, idx2 + 1, s1Size, s2Size);
            memo[idx1][idx2] = result ? 1 : 0;
            return result;
        }
        memo[idx1][idx2] = 0;
        return false;
    }
}