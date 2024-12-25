package me.coding.leetcode.code;

class Solution25 {
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        int pSize = size;
        long total = 0;
        int spn = Integer.MAX_VALUE;
        for(int i = 0 ; i < size ; i++){
            if(nums[i]>0){
                total+=nums[i];
                spn  = spn > nums[i] ? nums[i] : spn;
            }
            else pSize--;
        }
        long totalNorm = total - spn*pSize;
        long actTotal = (pSize * (pSize+1))/2;
        long mpnn = actTotal-totalNorm;
        int result = (int)(mpnn+spn);
        return result;
    }
}
