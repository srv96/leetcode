package me.coding.hackerrank;

import java.util.Hashtable;
import java.util.Map;

public class Solution3 {
    static Map<Integer, Integer> map = new Hashtable<>();

    static int maxSubSetSum(int[] arr, int idx) {
        if (idx >= arr.length) return 0;
        if(map.containsKey(idx))return map.get(idx);
        else{
            map.put(idx,Math.max(maxSubSetSum(arr, idx + 2) + arr[idx], maxSubSetSum(arr, idx + 1)));
        }
        return map.get(idx);
    }

    static int maxSubsetSum(int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return Math.max(arr[0], 0);
        return Math.max(maxSubSetSum(arr, 0), 0);
    }
}
