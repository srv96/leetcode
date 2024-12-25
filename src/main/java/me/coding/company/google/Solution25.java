package me.coding.company.google;

class Solution25 {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, 0, nums.length, 0, target);
    }

    private int findTargetSumWays(int[] nums, int idx, int size, int sum, int target) {
        if (idx == size){
           if(sum == target) return 1;
           else return 0;
        }
        else {
            return findTargetSumWays(nums, idx + 1, size, sum - nums[idx], target)
                    + findTargetSumWays(nums, idx + 1, size, sum + nums[idx], target);
        }
    }
}
