package me.coding.leetcode.top150;

class Solution2 {
    public int removeDuplicates(int[] nums) {
        int varSize = nums.length;
        for(int i = 0 ; i < varSize-2; i++){
            if(nums[i] == nums[i+1] && nums[i] == nums[i+2]){
                for(int j = i+2 ; j < varSize-1 ; j++){
                    nums[j] = nums[j+1];
                }
                varSize--;
                i--;
            }
        }
        return varSize;
    }
}
