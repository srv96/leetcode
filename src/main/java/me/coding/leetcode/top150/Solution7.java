package me.coding.leetcode.top150;

class Solution7 {
    public int hIndex(int[] citations) {
        int[] citationFreq = new int[1001];
        int size = citations.length;

        for (int i = 0; i < size; i++) {
            citationFreq[citations[i]]++;
        }
        int hIndex = 0;
        for (int i = 1000; i >= 0; i--) {
            citationFreq[i] += hIndex;
            hIndex = citationFreq[i];
        }
        int result = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i <= citationFreq[i]) result = i;
        }
        return result;
    }
}
