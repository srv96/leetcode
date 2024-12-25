package me.coding.company.google;

import java.util.Arrays;

class Solution20 {
    public int[] searchRange(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);
        if (pos < 0) return new int[]{-1, -1};
        else {
            int start = pos;
            int end = pos;
            while (start >= 0 && nums[start] == target) start--;
            while (end < nums.length && nums[end] == target) end++;
            return new int[]{start == 0 && nums[start] == target ? start : start + 1, end == nums.length - 1 && nums[end] == target ? end : end - 1};
        }
    }
}
