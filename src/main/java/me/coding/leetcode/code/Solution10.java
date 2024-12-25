package me.coding.leetcode.code;

class Solution10 {
    public int removeDuplicates(int[] num) {
        int length = num.length;
        int size = num.length;
        for(int  i = 0 ; i < size-1 ; i++){
            while(i<length && num[i] == num[i+1]){
                length--;
                for(int j = i+1 ; j < length ; j++){
                    num[j] = num [j+1];
                }
            }
        }
        return length+1;
    }
}
