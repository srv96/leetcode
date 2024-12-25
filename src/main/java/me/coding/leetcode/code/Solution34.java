package me.coding.leetcode.code;

import java.util.LinkedList;
import java.util.List;

class Solution34 {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(i+1);
        }
        int counter=0;
        while(list.size()!=1){
            counter = (counter+(k-1))%list.size();
            list.remove((counter));
        }
        return list.get(0);
    }
}