package me.coding.company.google;

class Solution34 {
    int[] prefixSum;

    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }

    public int helper(int[] nums, int goal) {
        if (goal < 0) return 0;
        int res = 0;
        int l = 0, curr = 0;
        for (int r = 0; r < nums.length; r++) {
            curr += nums[r];
            while (curr > goal) {
                curr -= nums[l];
                l++;
            }
            res += (r - l + 1);
        }
        return res;
    }

    private int sum(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }

    private void fillPrixSum(int[] nums) {
        int len = nums.length;
        prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = nums[i - 1];
        }
        for (int i = 1; i <= len; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
    }
}
