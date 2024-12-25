package me.coding.company.amazon;

import java.util.*;

class Solution5 {
    Map<Integer,List<Integer>> movement;
    int[][] memo;
    public void fillMemo(int n) {
        movement = new HashMap<>();
        movement.put(0,new ArrayList<>(Arrays.asList(4,6)));
        movement.put(1,new ArrayList<>(Arrays.asList(6,8)));
        movement.put(2,new ArrayList<>(Arrays.asList(7,9)));
        movement.put(3,new ArrayList<>(Arrays.asList(4,8)));
        movement.put(4,new ArrayList<>(Arrays.asList(0,3,9)));
        movement.put(6,new ArrayList<>(Arrays.asList(0,1,7)));
        movement.put(7,new ArrayList<>(Arrays.asList(2,6)));
        movement.put(8,new ArrayList<>(Arrays.asList(1,3)));
        movement.put(9,new ArrayList<>(Arrays.asList(2,4)));
        memo = new int[10][n+1];
        for(int i = 0 ; i < 10 ; i++){
            Arrays.fill(memo[i],-1);
        }
    }

    public int knightDialer(int n) {
        fillMemo(n);
        if(n==1)return 10;
        return getTotalCount(n);
    }

    private int getTotalCount(int n) {
        int counts = 0;
        for (int i = 0; i <= 9; i++) {
            if(i==5)continue;
            counts= (counts + count(i,n))%1000000007;
        }
        return counts;
    }

    private int count(int i, int n) {
        if(n==1)return 1;
        if(memo[i][n]==-1){
            List<Integer> moves = movement.get(i);
            int counts = 0;
            for(Integer move : moves){
                counts= (counts + count(move,n-1))%1000000007;
            }
            memo[i][n] = counts;
        }
        return memo[i][n];
    }
}