package me.coding.leetcode.ace75;

import java.util.Arrays;

class Solution4 {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2) return false;

        int[] charFreq1 = new int[26];
        int[] charFreq2 = new int[26];

        for(int i = 0 ; i < len1 ; i++){
            charFreq1[(int) word1.charAt(i) - 'a']++;
            charFreq1[(int) word2.charAt(i) - 'a']--;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(charFreq1[i]!=0) return false;
        }

        for (int i = 0; i < len1; i++) {
            charFreq1[(int) word1.charAt(i) - 'a']++;
            charFreq2[(int) word2.charAt(i) - 'a']++;
        }
        Arrays.sort(charFreq1);
        Arrays.sort(charFreq2);
        for (int i = len1; i >= 0; i--) {
            if(charFreq1[i]!=charFreq2[i])return false;
        }
        return true;
    }
}