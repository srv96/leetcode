package me.coding.leetcode.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution16 {
    Map<Integer, Integer> stockPrice;
    int current, max, min;
    Stack<Integer> maxPrice;

    public Solution16() {
        stockPrice = new HashMap<>();
        current = -1;
        max = -1;
        min = -1;
    }

    public void update(int timestamp, int price) {
        if (stockPrice.size() == 0) {
            max = timestamp;
            min = timestamp;
        }
        stockPrice.put(timestamp, price);
        current = current < timestamp ? timestamp : current;
        if(stockPrice.size()!=0){
            max = stockPrice.get(max) > price ? max : timestamp;
            min = stockPrice.get(min) < price ? min : timestamp;
        }
    }

    public int current() {
        return stockPrice.get(current);
    }

    public int maximum() {
        return stockPrice.get(max);
    }

    public int minimum() {
        return stockPrice.get(min);
    }
}
