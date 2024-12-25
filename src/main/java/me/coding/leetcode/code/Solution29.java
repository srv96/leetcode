package me.coding.leetcode.code;

class Solution29 {
    public int minPartitions(String n) {
        int max = Integer.MIN_VALUE;
        int size = n.length();
        for(int i = 0 ; i < size ; i++){
            max = Math.max(max,Integer.parseInt(String.valueOf(n.charAt(i))));
        }
        return max;
    }
}
