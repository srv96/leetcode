package me.coding.leetcode.top150;

import java.util.*;

class Solution23 {
    public boolean isOverLapped(int[] one , int[] two){
        if((two[0] >= one[0] && two[0] <= one[1]) || (two[1] >=one[0] && two[1] <= one[1])||
                (one[0] >= two[0] && one[0] <= two[1]) || (one[1] >=two[0] && one[1] <= two[1]))return true;

        else return false;
    }
    public int[] getMerge(int[] one , int[] two){
        int merge[] = new int[2];
        merge[0] = one[0] < two[0] ? one[0] : two[0];
        merge[1] = one[1] > two[1] ? one[1] : two[1];
        return merge;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            intervals = new int[1][2];
            intervals[0][0] = newInterval[0];
            intervals[0][1] = newInterval[1];
            return intervals;
        }

        Queue<int[]> interValQueue = Arrays.stream(intervals).collect(ArrayDeque::new, Queue::offer, Queue::addAll);

        int count = 0;
        while(!isOverLapped(interValQueue.peek(),newInterval) && count<intervals.length){
            interValQueue.offer(interValQueue.poll());
            count++;
        }
        while(!interValQueue.isEmpty()&&isOverLapped(interValQueue.peek(),newInterval)){
            newInterval = getMerge(interValQueue.poll(),newInterval);
        }
        interValQueue.offer(newInterval);

        int[][] result =  interValQueue.stream().toArray(int[][]::new);
        Arrays.sort(result, Comparator.comparingInt((int[] arr) -> arr[0])
                .thenComparingInt(arr -> arr[1]));
        return result;
    }
}
