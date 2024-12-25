package me.coding.leetcode.top150;

import java.util.*;

class Solution17 {
    public int[][] merge(int[][] intervals) {
        for(int i = 0 ; i < 5 ; i++){
            List<int[]> overlaps = new ArrayList<>();
            for (int[] interval : intervals) {
                boolean found = false;
                for (int j = 0 ; j < overlaps.size() ; j++) {
                    if (interval[0] <= overlaps.get(j)[1] && interval[0] >= overlaps.get(j)[0] ||
                            interval[1] <= overlaps.get(j)[1] && interval[1] >= overlaps.get(j)[0] ||
                            overlaps.get(j)[0] <= interval[1] && overlaps.get(j)[1] >= interval[0] ||
                            overlaps.get(j)[0] <= interval[1] && overlaps.get(j)[1] >= interval[0]) {
                        overlaps.set(j, new int[]{interval[0] < overlaps.get(j)[0] ? interval[0] : overlaps.get(j)[0],
                                interval[1] > overlaps.get(j)[1] ? interval[1] : overlaps.get(j)[1]});
                        found = true;

                    }
                }
                if(!found){
                    overlaps.add(interval);
                    found = false;
                }
            }
            intervals = overlaps.stream().toArray(int[][]::new);
        }
        return intervals;
    }
}