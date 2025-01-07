package me.coding.company.google;

import java.util.*;

class Solution45 {
    public int findMinDifference(List<String> timePoints) {

        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        int size = timePoints.size();
        int mindiff = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            mindiff = Math.min(mindiff, diff(timePoints.get(i), timePoints.get((i + 1) % size)));
        }
        return mindiff;
    }

    private int diff(String t1, String t2) {
        StringTokenizer st = new StringTokenizer(t1, ":");

        int h1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int min1 = h1 * 60 + m1;

        st = new StringTokenizer(t2, ":");
        int h2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int min2 = h2 * 60 + m2;

        int maxMin = 24 * 60;
        if(min1 > min2){
            return (maxMin - min1) + min2;
        }else{
            return min2 - min1;
        }

    }
}
