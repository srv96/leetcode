package me.coding.mostliked;

import java.util.HashMap;
import java.util.Map;

class Solution3 {
    Map<Integer, Integer> memo;
    public int rob(int[] nums) {
        memo = new HashMap<>();
        return robber(nums, 0, nums.length);
    }
    private int robber(int[] nums, int i, int length) {
        if (i >= length) return 0;
        else {
            if (!memo.containsKey(i)) memo.put(i, Math.max(nums[i] + robber(nums, i + 2, length), robber(nums, i + 1, length)));
            return memo.get(i);
        }
    }
}
