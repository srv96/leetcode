package me.coding.company.google;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution38 {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        for(int[] task :tasks){
            pq.add(task);
        }
        int[] result = new int[tasks.length];
        for(int i = 0 ; i < tasks.length;i++){
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
