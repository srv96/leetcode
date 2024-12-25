package me.coding.leetcode.top150;

import java.util.Arrays;

class Solution45 {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)return 0;
        int rSize = obstacleGrid.length;
        int cSize = obstacleGrid[0].length;
        memo = new int[rSize][cSize];
        for (int i = 0; i < rSize; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        memo[rSize-1][cSize-1] = 1;
        int result = uniquePaths(obstacleGrid,rSize,cSize,0,0);
        return result;
    }

    private int uniquePaths(int[][] obstacleGrid, int rSize, int cSize, int r, int c) {
        if(memo[r][c]!=Integer.MIN_VALUE)return memo[r][c];
        int right=0,down=0;
        if(r<rSize-1&&obstacleGrid[r+1][c]!=1)down=uniquePaths(obstacleGrid,rSize,cSize,r+1,c);
        if(c<cSize-1&&obstacleGrid[r][c+1]!=1)right=uniquePaths(obstacleGrid,rSize,cSize,r,c+1);
        memo[r][c]=right+down;
        return memo[r][c];
    }
}
