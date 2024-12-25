package me.coding.company.microsoft;

import java.util.Arrays;

class Solution14 {
    int[] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        for (int i = nums.length - 1; i >= 0; i--) {
            llis(nums, i, nums.length);
        }
        return Arrays.stream(memo).max().getAsInt();
    }

    private void llis(int[] nums, int i, int length) {
        if (i == length - 1) {
            memo[i] = 1;
            return;
        }

        if (memo[i] == -1) {
            int maxLen = 0;
            for (int j = i + 1; j < length; j++) {
                if (nums[i] < nums[j]) {
                    maxLen = Math.max(maxLen, memo[j]);
                }
            }
            memo[i] = 1 + maxLen;
        }
    }
}
