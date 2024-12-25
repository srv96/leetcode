package me.coding.leetcode.top150;

import java.util.HashMap;
import java.util.Map;

class Solution6 {
    Map<Integer,Integer> memo = new HashMap<>();
    public Integer minJump(int[] nums,int idx){
        if(idx == nums.length-1){
            memo.put(idx,0);
            return 0;
        }
        if(idx >= nums.length || nums[idx]==0){
            if(memo.get(idx)!=null)memo.put(idx,Integer.MAX_VALUE/2);
            return Integer.MAX_VALUE/2;
        }
        int minJump = Integer.MAX_VALUE/2;
        for(int i = nums[idx] ; i>=1 ; i--){
            if(memo.get(idx+i)!=null){
                int tgtmin = memo.get(idx+i);
                minJump = minJump < tgtmin ? minJump : tgtmin;
            }else{
                int tgtmin = minJump(nums,idx+i);
                minJump = minJump < tgtmin ? minJump : tgtmin;
            }
        }
        memo.put(idx,1+minJump);
        return 1+minJump;
    }
    public int jump(int[] nums) {
        return minJump(nums,0);
    }
}
