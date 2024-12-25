package me.coding.company.google;

class Solution24 {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        int numLen = nums.length;
        for (int i = 0; i < numLen; i++) {
            result.append(nums[i].charAt(i)=='1'?'0':'1');
        }
        return result.toString();
    }
}