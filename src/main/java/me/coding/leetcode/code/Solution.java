package me.coding.leetcode.code;

import me.coding.ds.list.NestedInteger;

import java.util.List;

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getDepth(nestedList, 0);
        return invSum(nestedList, maxDepth);
    }

    private int getDepth(List<NestedInteger> nestedList, int depth) {
        int maxDepth = depth + 1;
        for (NestedInteger integer : nestedList) {
            if (!integer.isInteger()) {
                maxDepth = Math.max(maxDepth, getDepth(integer.getList(), depth + 1));
            }
        }
        return maxDepth;
    }

    private int invSum(List<NestedInteger> nestedList, int depth) {
        int size = nestedList.size();
        int sum = 0;
        for (NestedInteger integer : nestedList) {
            sum += integer.isInteger() ? integer.getInteger() * depth : invSum(integer.getList(), depth - 1);
        }
        return sum;
    }

}