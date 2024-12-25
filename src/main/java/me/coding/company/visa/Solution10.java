package me.coding.company.visa;

class Solution10 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (l == mid && mid == r && nums[mid] != target) return -1;
            if (nums[mid] == target) return mid;
            if (mid + 1 <= r && nums[mid + 1] <= nums[r]) {
                if (nums[mid + 1] <= target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
                continue;
            }
            if (mid - 1 >= l && nums[l] <= nums[mid - 1]) {
                if (nums[l] <= target && nums[mid - 1] >= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}