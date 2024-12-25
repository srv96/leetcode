package me.coding.leetcode.code;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution43 {
    static class Pair {
        public char ch;
        public int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) map.put(ch, 1);
            else map.put(ch, map.get(ch) + 1);
        }
        for (Character ch : map.keySet()) {
            pq.add(new Pair(ch, map.get(ch)));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            for(int i = 0 ; i < p.freq ; i++){
                stringBuilder.append(p.ch);
            }
        }
        return stringBuilder.toString();
    }
}

