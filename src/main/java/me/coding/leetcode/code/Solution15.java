package me.coding.leetcode.code;

import java.util.Arrays;
import java.util.List;

class Solution15 {
    public List<String> printVertically(String s) {
        String[] tokens = s.split(" ");
        int maxSize = 0;
        for (String token : tokens) {
            maxSize = maxSize < token.length() ? token.length() : maxSize;
        }
        String[] inverted = new String[maxSize];
        for (int i = 0; i < maxSize; i++) {
            inverted[i] = "";
        }

        for (int i = 0; i < maxSize; i++) {
            for (String token : tokens) {
                if (token.length() > i) {
                    inverted[i] += token.charAt(i);
                } else {
                    inverted[i] += " ";
                }
            }
        }
        for (int i = 0; i < maxSize; i++) {
            inverted[i] = inverted[i].replaceAll("\\s+$", "");
        }
        return Arrays.asList(inverted);
    }

    public static void main(String[] args) {
        String s = "TO BE OR NOT TO BE";
        List<String> result = new Solution15().printVertically(s);
        result.forEach(System.out::println);
    }
}
