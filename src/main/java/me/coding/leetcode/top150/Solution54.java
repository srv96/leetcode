package me.coding.leetcode.top150;

class Solution54 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = max > sum ? max : sum;
            sum = sum > 0 ? sum : 0;
        }
        return max;
    }
}