package me.coding.leetcode.top150;

class Solution8 {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int size = nums.length;
        int zeroCount = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                product *= nums[i];
            }
        }
        int[] result = new int[nums.length];
        if (zeroCount > 1) {
            return result;
        } else if (zeroCount == 1) {

            for (int i = 0; i < size; i++) {
                if (nums[i] == 0) result[i] = product;
                else result[i] = 0;
            }
        } else {

            for (int i = 0; i < size; i++) {
                result[i] = product / nums[i];
            }
        }
        return result;
    }
}
