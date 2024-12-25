package me.coding.leetcode.strivers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = powerSet(0, nums);
        return result;
    }

    private List<List<Integer>> powerSet(int idx, int[] nums) {
        if (idx >= nums.length) {
            List<List<Integer>> seed = new ArrayList<>();
            seed.add(new ArrayList<>());
            return seed;
        }
        int nextIdx = getNextIdx(nums, idx);
        List<List<Integer>> addSubSet = powerSet(idx + 1, nums);
        addSubSet.forEach(set -> set.add(nums[idx]));
        List<List<Integer>> ignoreSubSet = powerSet(nextIdx, nums);
        addSubSet.addAll(ignoreSubSet);
        System.gc();
        return addSubSet;
    }

    private int getNextIdx(int[] nums, int idx) {
        int nextIdx = idx + 1;
        while (nextIdx < nums.length && nums[idx] == nums[nextIdx]) nextIdx++;
        return nextIdx;
    }
}
