package me.coding.leetcode.top150;

import java.util.Arrays;

class Solution44 {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int rSize = grid.length;
        int cSize = grid[0].length;
        memo = new int[rSize][cSize];
        for (int i = 0; i < rSize; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        memo[rSize-1][cSize-1] = grid[rSize-1][cSize-1];
        int result = minSum(grid,rSize,cSize,0,0);
        return result;
    }

    private int minSum(int[][] grid,int rSize,int cSize,int r, int c) {
        if(memo[r][c] !=Integer.MAX_VALUE)return memo[r][c];
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(r<rSize-1){
            down = minSum(grid,rSize,cSize,r+1,c);
        }
        if(c<cSize-1) {
            right = minSum(grid, rSize, cSize, r, c+1);
        }
        memo[r][c] = grid[r][c] + Math.min(down,right);
        return memo[r][c];
    }
}
