package me.coding.company.deshaw;

public class TestSolution {
    public static void main(String[] args) {
//        int[][] grid = new int[][]{
//                {3,1,2,2,}
//                ,{1,4,4,5}
//                ,{2,4,2,2}
//                ,{2,4,2,2}
//        };
        int[][] grid = {
                {3}
        };
        Solution s = new Solution();
        System.out.println(s.equalPairs(grid));
    }
}
