package me.coding.company.visa;

class Solution8 {
    public int findUnsortedSubarray(int[] nums) {
        int size = nums.length;
        int l = 0, r = size - 1;
        for (int i = 1; i < size; i++) {
            if (nums[i - 1] > nums[i]) {
                l = i - 1;
                break;
            }
        }
        for (int i = size - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                r = i + 1;
                break;
            }
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (nums[l] == min && nums[r] == max) return 0;
        if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) return size;
        int lIdx = 0, rIdx = 0;
        if (min < nums[0]) {
            lIdx = 0;
        } else {
            for (int i = 0; i < size - 1; i++) {
                if (nums[i] <= min && nums[i + 1] > min) {
                    lIdx = i + 1;
                    break;
                }
            }
        }
        if (max > nums[size - 1]) {
            rIdx = size - 1;
        } else {
            for (int i = size - 1; i > 0; i--) {
                if (nums[i - 1] < max && nums[i] >= max) {
                    rIdx = i - 1;
                    break;
                }
            }
        }
        return (rIdx - lIdx) + 1;
    }
}
