package me.coding.company.walmart;

class Solution9 {
    public int numberOfSubarrays(int[] nums, int k) {
        if (k == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2 == 0 ? 0 : 1;
        }
        return countSubArraySmallerThenK(nums, k) - countSubArraySmallerThenK(nums, k - 1);
    }

    private int countSubArraySmallerThenK(int[] nums, int k) {
        int l = 0, r = 0;
        int sum = 0;
        int count = 0;
        while (r < nums.length) {
            sum += nums[r];
            if (sum <= k) {
                count += (r - l) + 1;
                r++;
            } else {
                while (sum > k) {
                    sum -= nums[l];
                    l++;
                }
                count += (r - l) + 1;
                r++;
            }
        }
        return count;
    }
}
