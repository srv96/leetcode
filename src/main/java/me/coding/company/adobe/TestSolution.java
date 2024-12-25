package me.coding.company.adobe;

import java.util.List;

public class TestSolution {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        List<List<Integer>> result = s.findMatrix(nums);
        System.out.println(result);
    }
}
