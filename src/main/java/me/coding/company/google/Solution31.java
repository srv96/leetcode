package me.coding.company.google;

class Solution31 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] zeroArray = new int[nums.length + 1];
        for (int i = 0; i < queries.length; i++) {
            zeroArray[queries[i][0]]++;
            zeroArray[queries[i][1] + 1]--;
        }
        for (int i = 1; i < zeroArray.length; i++) {
            zeroArray[i] += zeroArray[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > zeroArray[i]) return false;
        }
        return true;
    }
}
