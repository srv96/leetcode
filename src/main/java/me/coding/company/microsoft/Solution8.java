package me.coding.company.microsoft;

import java.util.HashMap;
import java.util.Map;

class Solution8 {
    public int findMaxLength(int[] nums) {
        int diff = 0, maxLen = 0;
        Map<Integer, Integer> diffIdxMap = new HashMap<>();
        int size = nums.length;
        diffIdxMap.put(0,-1);
        for (int i = 0; i < size; i++) {
            diff += nums[i] == 1 ? 1 : -1;
            if (diffIdxMap.containsKey(diff)) {
                maxLen = Math.max(maxLen,i-diffIdxMap.get(diff));
            }else{
                diffIdxMap.put(diff,i);
            }
        }
        return maxLen;
    }
}
