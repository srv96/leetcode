package me.coding.leetcode.top150;

class Solution14 {
    public int trailingZeroes(int n) {
        int n_1 = n;
        int count5 = 0;
        while(n_1>=5){
            count5++;
            n_1/=5;
        }
        int total_5 = 0;
        int divisior = 5;
        for(int i = 0 ; i < count5 ; i++){
            total_5+=n/divisior;
            divisior*=5;
        }
        return total_5;
    }
}
