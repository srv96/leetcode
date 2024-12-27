package me.coding.leetcode.code;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String stringHash(String s, int k) {
        List<String> subStr = getSubString(s, k);
        StringBuilder sb = new StringBuilder();
        for (String str : subStr) {
            sb.append(getHash(str));
        }
        return sb.toString();
    }

    private char getHash(String str) {
        int len = str.length();
        int hashValue = 0;
        for (int i = 0; i < len; i++) {
            hashValue += str.charAt(i) - 'a';
        }
        hashValue %= 26;
        return (char) ((int) 'a' + hashValue);
    }

    public List<String> getSubString(String s, int k) {
        int size = s.length();
        List<String> subStr = new ArrayList<>();
        for (int i = 0; i < size; i += k) {
            subStr.add(s.substring(i, Math.min(size, i + k)));
        }
        return subStr;
    }
}
