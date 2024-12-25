package me.coding.company.amazon;

import me.coding.ds.search.SegmentTree;

class Solution4 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        SegmentTree segmentTree = new SegmentTree(nums);
        int size = nums.length;
        double l = lower, u = upper;
        int count = 0;
        double[] seg = segmentTree.segment;
        for (int i = 0; i < segmentTree.maxSize; i++) {
            if (seg[i] <= u && seg[i] >= l) count++;
        }
        return count;
    }
}
