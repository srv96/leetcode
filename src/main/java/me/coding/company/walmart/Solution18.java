package me.coding.company.walmart;

class Solution18 {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int nZero = 0;
        int len = 0, maxLen = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                len = (r - l) + 1;
                maxLen = Math.max(maxLen, len);
                r++;
            } else {
                nZero++;
                if (nZero <= k) {
                    len = (r - l) + 1;
                    maxLen = Math.max(maxLen, len);
                    r++;
                } else {
                    while (nZero > k) {
                        if (nums[l] != 0) {
                            l++;
                        } else {
                            nZero--;
                            l++;
                        }
                    }
                    len = (r - l) + 1;
                    maxLen = Math.max(maxLen, len);
                    r++;
                }
            }
        }
        return maxLen;
    }
}
