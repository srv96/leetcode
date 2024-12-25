package me.coding.leetcode.code;

import java.util.ArrayList;
import java.util.List;
class Solution27 {
    public List<Integer> findDuplicates(int[] nums) {
        int size = nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < size ; i++){
            if(nums[Math.abs(nums[i])-1]<0){
                result.add(Math.abs(nums[i]));
            }else{
                nums[Math.abs(nums[i])-1]*=-1;
            }
        }
        return result;
    }
}

