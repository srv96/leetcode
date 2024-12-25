package me.coding.company.google;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Solution41 {
    public char findKthBit(int n, int k) {
        List<Boolean> result = recursion(n);
        return result.get(k-1) ? '1' : '0' ;
    }

    private List<Boolean> recursion(int n) {
        if(n == 1) return new ArrayList<>(Arrays.asList(false));
        else {
            List<Boolean> result = new ArrayList<>();
            List<Boolean> sn_1 = recursion(n-1);
            result.addAll(sn_1);
            result.add(true);
            Collections.reverse(invert(sn_1));
            result.addAll(sn_1);
            return result;
        }
    }

    private List<Boolean> invert(List<Boolean> list) {
        int len = list.size();
        for(int i = 0 ; i < len;i++){
            list.set(i , !list.get(i));
        }
        return list;
    }
}
