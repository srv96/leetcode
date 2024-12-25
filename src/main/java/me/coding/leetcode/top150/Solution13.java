package me.coding.leetcode.top150;

import java.util.HashSet;
import java.util.Set;

class Solution13 {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        int lcs = Integer.MIN_VALUE;
        for(Integer num : numSet){
            if(numSet.contains(num-1))continue;
            else{
                int cs = 1;
                while(numSet.contains(num+cs))cs++;
                lcs = cs > lcs ? cs : lcs;
            }
        }
        return lcs;
    }
}