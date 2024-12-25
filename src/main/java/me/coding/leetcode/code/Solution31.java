package me.coding.leetcode.code;

import java.util.*;

class Solution31 {
    public int maxSatisfaction(int[] satisfaction) {
        List<Integer> lst = new ArrayList<>();
        lst.add(0);
        Arrays.sort(satisfaction);
        int size = satisfaction.length;
        for(int i = 0 ; i < size ; i++){
            int sum = 0;
            int idx = 1;
            for(int j = i ; j < size ; j++){
                sum+=satisfaction[j]*idx;
                idx++;
            }
            lst.add(sum);
        }
        return lst.stream().mapToInt(Integer::intValue).max().orElseThrow();
    }
}
