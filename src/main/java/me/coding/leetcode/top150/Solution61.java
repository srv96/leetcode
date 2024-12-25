package me.coding.leetcode.top150;

import java.util.Arrays;

class Solution61 {
    public String largestNumber(int[] nums) {
        int size = nums.length;
        String[] bigNumberStr = new String[size];
        for (int i = 0; i < size; i++) bigNumberStr[i] = String.valueOf(nums[i]);
        Arrays.sort(bigNumberStr, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) resultBuilder.append(bigNumberStr[i]);
        while (resultBuilder.length() > 0 && resultBuilder.charAt(0) == '0') resultBuilder.deleteCharAt(0);
        return resultBuilder.length() > 0 ? resultBuilder.toString() : "0";
    }
}
