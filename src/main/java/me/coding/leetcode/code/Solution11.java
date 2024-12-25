package me.coding.leetcode.code;

class Solution11 {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int profit=0;
        for(int i = 0 ; i < size-1 ; i++){
            profit+= prices[i+1]>prices[i] ? prices[i+1]-prices[i] : 0 ;
        }
        System.gc();
        return profit;
    }
}
