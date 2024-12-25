package me.coding.leetcode.top150;

class Solution53 {
    public int gradient(int[] nums, int idx) {
        if (idx == 0 && nums[idx] > nums[idx + 1]) return 0;
        if (idx == 0 && nums[idx] < nums[idx + 1]) return 1;
        if (idx == nums.length - 1 && nums[idx] > nums[idx - 1]) return 0;
        if (idx == nums.length - 1 && nums[idx] < nums[idx - 1]) return -1;
        if (nums[idx] > nums[idx - 1] && nums[idx] > nums[idx + 1]) return 0;
        if (nums[idx] > nums[idx - 1] && nums[idx] < nums[idx + 1]) return 1;
        if (nums[idx] < nums[idx - 1] && nums[idx] > nums[idx + 1]) return -1;
        if (nums[idx] < nums[idx - 1] && nums[idx] < nums[idx + 1]) return 1;
        return Integer.MIN_VALUE;
    }

    public int findPeakElement(int[] nums) {
        int size = nums.length;
        if(size==1)return 0;
        int l = 0, r = size;
        while (true) {
            int mid = (l + r) / 2;
            int grad = gradient(nums, mid);
            if (grad == 0) return mid;
            if (grad ==1)l=mid;
            else if(grad==-1)r=mid;
        }
    }
}
