package me.coding.leetcode.code;

import me.coding.ds.list.NestedInteger;

import java.util.List;

class Solution51 {
    public int depthSum(List<NestedInteger> nestedInteger) {
        return sum(nestedInteger,1);
    }

    private int sum(List<NestedInteger> nestedList, int depth) {
        int size = nestedList.size();
        int sum = 0;
        for(NestedInteger integer : nestedList){
            sum += integer.isInteger() ? integer.getInteger() * depth : sum(integer.getList(),depth+1);
        }
        return sum;
    }
}
