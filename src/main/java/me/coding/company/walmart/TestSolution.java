package me.coding.company.walmart;

import java.util.List;

public class TestSolution {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,3,5,4,1,3,2};
        int target = 10;
        List<List<Integer>> result = new Solution19().combinationSum2(nums,target);
        System.out.println(result);
    }
}
