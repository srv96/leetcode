package me.coding.leetcode.code;

import java.util.Hashtable;
import java.util.Map;

class Solution38 {
    Map<Integer, Integer> memo;
    public Solution38(){
        memo = new Hashtable<>();
        memo.put(0,1);
        memo.put(1,1);
        memo.put(2,2);
    }
    public int numTrees(int n) {
        if(!memo.containsKey(n)){
            int result = 0;
            for (int i = 0; i < n; i++) {
                result += (numTrees(i) * numTrees(n - 1 - i));
            }
            memo.put(n,result);
        }
        return memo.get(n);
    }
}