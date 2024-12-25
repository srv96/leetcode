package me.coding.leetcode.code;

class Solution12IC {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        int[] temp = new int[k];
        for (int i = size - k; i < size; i++)temp[i - size + k] = nums[i];
        for(int i = size-1 ; i>=k;i--)nums[i] = nums[i-k];
        for(int i = 0 ; i < k ;i++)nums[i] = temp[i];
    }
}
