package me.coding.mostliked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    public Map<Integer,Integer> memo;
    public int numSquares(int n) {
        memo = new HashMap<>();
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        int size = squares.size();
        int result = getSquareSum(n, squares, size);
        return result-1;
    }

    private int getSquareSum(int n, List<Integer> squares, int size) {
        if(memo.containsKey(n))return memo.get(n);
        if (n == 0) return 1;
        if (n < 0) return Integer.MAX_VALUE;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            count = Math.min(count, getSquareSum(n - squares.get(i), squares, size));
        }
        count = count != Integer.MAX_VALUE ? count+1 : Integer.MAX_VALUE;
        memo.put(n,count);
        return count;
    }
}
