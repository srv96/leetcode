package me.coding.company.google;

import java.util.*;

class Solution12 {
    public int minAreaRect(int[][] points) {
        if(points.length<4)return 0;
        Map<Integer, Set<Integer>> X = new HashMap<>();
        int size = points.length;
        for (int[] point : points) {
            if (!X.containsKey(point[0])) {
                X.put(point[0], new TreeSet<>(List.of(point[1])));
            } else {
                Set<Integer> group = X.get(point[0]);
                group.add(point[1]);
                X.put(point[0], group);
            }
        }
        List<Integer> xValue = new ArrayList<>(X.keySet());
        int xSize = xValue.size();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < xSize; i++) {
            for (int j = i + 1; j < xSize; j++) {
                Set<Integer> interSec = new TreeSet<>(X.get(xValue.get(i)));
                interSec.retainAll(X.get(xValue.get(j)));
                if (interSec.size() >= 2) {
                    result = Math.min(result, calculateMaxArea(xValue.get(i), xValue.get(j), new ArrayList<>(interSec)));
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private int calculateMaxArea(int x1, int x2, List<Integer> ys) {
        Collections.sort(ys);
        int max = Integer.MAX_VALUE;
        int size = ys.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                max = Math.min(max , Math.abs(x1-x2) * Math.abs(ys.get(i)-ys.get(j)));
            }
        }
        return max;
    }

}
