package me.coding.mostliked;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))return false;
            left++;right--;
        }
        return true;
    }

    void part(List<List<String>> result, List<String> currentPartition, StringBuilder str, int idx, int size) {
        if (idx == size) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }
        for (int i = idx + 1; i <= size; i++) {
            String subStr = str.substring(idx, i);
            if(isPalindrome(subStr)){
                currentPartition.add(subStr);
                part(result, currentPartition, str, i, size);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        StringBuilder str = new StringBuilder(s);
        List<List<String>> result = new ArrayList<>();
        part(result, new ArrayList<>(), str, 0, str.length());
        return result;
    }
}
