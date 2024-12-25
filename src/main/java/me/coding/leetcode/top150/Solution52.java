package me.coding.leetcode.top150;

class Solution52 {
    public int singleNumber(int[] nums) {
        long ones=0,twos=0,size=nums.length;
        for(int i = 0 ; i < size;i++){
            ones = ones ^ nums[i] & ~twos;
            twos = twos ^ nums[i] & ~ones;
        }
        return (int) ones;
    }
}