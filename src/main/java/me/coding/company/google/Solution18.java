package me.coding.company.google;

import java.util.Arrays;

class Solution18 {
    public int subarraySum(int[] nums, int k) {
        Arrays.parallelPrefix(nums, (x, y) -> x + y);
        int size = nums.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = -1; j < i; j++) {
                if (j == -1) {
                    if (nums[i] == k) count ++;
                    continue;
                }
                if (nums[i] - nums[j] == k) count++;
            }
        }
        return count;
    }
}

