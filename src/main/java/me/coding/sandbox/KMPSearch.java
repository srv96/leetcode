package me.coding.sandbox;

import java.util.Arrays;

public class KMPSearch {
    public int[] getLPS(String needle) {
        int length = needle.length();
        int[] lps = new int[length];
        Arrays.fill(lps, 0);
        int prevLPS = 0, i = 1;
        while (i < length) {
            if (needle.charAt(i) == needle.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            } else {
                if (prevLPS == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prevLPS = lps[prevLPS - 1];
                }
            }
        }
        return lps;
    }

    public int getFirstOccurrenceIndex(String hayStack, String needle) {
        int[] lps = getLPS(needle);
        int size = hayStack.length();
        int i = 0, j = 0;

        while (i < size) {
            if (hayStack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
            if (j == needle.length()) return i - needle.length();
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new KMPSearch().getFirstOccurrenceIndex("AAAXAAAAA", "AAAA"));
    }
}
