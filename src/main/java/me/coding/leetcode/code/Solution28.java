package me.coding.leetcode.code;

class Solution28 {
    public String getSmallestString(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            stringBuilder.append('a');
            k--;
        }
        while(k!=0&&n>=0){
            int possible = Math.min(k,25);
            stringBuilder.setCharAt(n-1,(char)('a'+possible));
            k-=possible;
            n--;
        }
        return stringBuilder.toString();
    }
}
