package me.coding.leetcode.top150;

class Solution46Repeat {
    public String longestPalindrome(String s) {
        String processedStr = s.replaceAll("", "#");
        int size = processedStr.length();
        int[] lpRadius = new int[size];
        int center = 0, right = 0, l, r;
        for (int i = 0; i < size; i++) {
            if (i < right) lpRadius[i] = Math.min(right - i, lpRadius[2 * center - i]);

            l = i - (1 + lpRadius[i]);
            r = i + (1 + lpRadius[i]);

            while (l >= 0 && r < size && processedStr.charAt(l) == processedStr.charAt(r)) {
                lpRadius[i]++;
                r++;
                l--;
            }
            if (i + lpRadius[i] > right) {
                center = i;
                right = i + lpRadius[i];
            }
        }
        int maxRadius = 0, centerIdx = 0;
        for (int i = 0; i < size; i++) {
            if (maxRadius < lpRadius[i]) {
                maxRadius = lpRadius[i];
                centerIdx = i;
            }
        }
        int actCenter = (centerIdx - maxRadius) / 2;
        return s.substring(actCenter,actCenter+maxRadius);
    }
}
