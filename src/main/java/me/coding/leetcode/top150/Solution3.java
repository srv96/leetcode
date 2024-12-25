package me.coding.leetcode.top150;

class Solution3 {
    public void rotate(int[] nums, int k) {
        if(k >= nums.length) k = k%nums.length;
        int size = nums.length;
        int[] temp = new int[k];
        for (int i = size - k; i < size; i++)temp[i - size + k] = nums[i];
        for(int i = size-1 ; i>=k;i--)nums[i] = nums[i-k];
        for(int i = 0 ; i < k ;i++)nums[i] = temp[i];
    }
}
