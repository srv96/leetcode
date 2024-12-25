package me.coding.leetcode.top150;

class Solution55 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0],curr_max=nums[0],max=nums[0],
                curr_min=nums[0],min=nums[0],size=nums.length;
        if(size==1)return nums[0];
        for(int i = 1 ; i < size ; i++){
            sum+=nums[i];
            curr_max = Math.max(curr_max+nums[i],nums[i]);
            max = Math.max(curr_max,max);
            curr_min =Math.min(curr_min+nums[i],nums[i]);
            min = Math.min(curr_min,min);
        }
        return (sum==min) ? max :Math.max(max,sum-min);
    }
}
