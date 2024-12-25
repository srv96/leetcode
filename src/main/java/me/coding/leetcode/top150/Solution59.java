package me.coding.leetcode.top150;

import java.util.Arrays;

class Solution59 {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        int w1Size = word1.length();
        int w2Size = word2.length();
        memo = new int[w1Size][w2Size];
        for(int[] rows : memo) Arrays.fill(rows,Integer.MAX_VALUE);
        return minDistance(word1,word2,w1Size-1,w2Size-1);
    }

    private int minDistance(String word1, String word2, int i, int j) {
        if(i==-1)return j+1;
        if(j==-1)return i+1;

        if(word1.charAt(i)==word2.charAt(j)){
            if(memo[i][j]!=Integer.MAX_VALUE)return memo[i][j];
            int subMinDist = minDistance(word1,word2,i-1,j-1);
            memo[i][j]=subMinDist;
            return subMinDist;
        }else{
            if(memo[i][j]!=Integer.MAX_VALUE)return memo[i][j];
            int insert = 1+minDistance(word1,word2,i,j-1);
            int delete = 1+minDistance(word1,word2,i-1,j);
            int update = 1+minDistance(word1,word2,i-1,j-1);
            int subMinDist =Math.min(Math.min(insert, delete), update);
            memo[i][j]=subMinDist;
            return subMinDist;
        }
    }
}
