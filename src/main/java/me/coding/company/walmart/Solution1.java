package me.coding.company.walmart;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

class Solution1 {
    public int maximumProfit(int[] present, int[] future, int budget) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                double eps1 = ((double) o1.getValue() - (double) o1.getKey()) / (double) o1.getKey();
                double eps2 = ((double) o2.getValue() - (double) o2.getKey()) / (double) o2.getKey();
//                System.out.println("comparing " + o1 + " and " + o2);
//                System.out.println("eps of o1 " + eps1);
//                System.out.println("eps of o2 " + eps2);
                return eps1 > eps2 ? -1 : 1;
            }
        });
        int size = present.length;
        for (int i = 0; i < size; i++) {
            pq.add(new AbstractMap.SimpleEntry<>(present[i], future[i]));
        }
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> poll = pq.poll();
            double val = Double.parseDouble(String.valueOf(poll.getValue()));
            double key = Double.parseDouble(String.valueOf(poll.getKey()));
            System.out.println(poll.getKey() + " " + poll.getValue() + "  =>  " + (val - key) / key);
        }
        return 0;
    }
}
