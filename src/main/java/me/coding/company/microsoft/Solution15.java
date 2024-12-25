package me.coding.company.microsoft;

class Solution15 {
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[nums[0]]], slow = nums[nums[0]];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}