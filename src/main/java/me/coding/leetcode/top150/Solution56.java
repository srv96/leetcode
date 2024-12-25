package me.coding.leetcode.top150;

class Solution56 {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int size = nums.length;
        int l = 0, r = 0;
        for (r = 0; r < size; r++) {
            if(nums[r]>target)return 1;
            sum += nums[r];
            if(sum==target)minLength = Math.min(r - l+1, minLength);
            while (sum - nums[l] >= target) {
                minLength = Math.min(r - l, minLength);
                sum -= nums[l];
                l++;
            }
        }
        if (sum < target) return 0;
        else  return Math.min(r - l+1, minLength) > size ? size : Math.min(r - l+1, minLength);
    }
}
