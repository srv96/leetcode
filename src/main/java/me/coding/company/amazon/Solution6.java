package me.coding.company.amazon;

import java.util.Arrays;

class Solution6 {
    int[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int size = arr.length;
        memo = new int[size];
        Arrays.fill(memo,-1);
        return getMaxPartition(arr, 0, size, k);
    }

    private int getMaxPartition(int[] arr, int idx, int size, int k) {
        if (idx == size) return 0;
        if(memo[idx]==-1){
            int maxLoop = Math.min(k, size - idx);
            int maxSum = Integer.MIN_VALUE;
            for(int i = 0 ; i < maxLoop ; i++){
                maxSum = Math.max(maxSum , calcSum(arr,idx,idx+i) + getMaxPartition(arr,idx+i+1,size,k));
            }
            memo[idx] = maxSum;
        }
        return memo[idx] ;
    }

    private int calcSum(int[] arr , int start , int end){
        int max = getMax(arr,start,end);
        return start == end ? max : (end-start+1) * max;
    }
    private int getMax(int[] arr, int start, int end) {
        if (start == end) return arr[start];
        else {
            int max = Integer.MIN_VALUE;
            for (int i = start ; i <= end ; i++){
                max = Math.max(max,arr[i]);
            }
            return max;
        }
    }
}
