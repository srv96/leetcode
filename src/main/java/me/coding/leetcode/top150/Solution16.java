package me.coding.leetcode.top150;

import java.util.Arrays;
import java.util.Comparator;

class Solution16 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing((int[] a) -> a[1]));
        int balloonNum = points.length;
        int arrowNum = 0;
        int i = 0 ;
        while(i < balloonNum){
            int arrowPos = points[i][1];
            int j = i;
            arrowNum++;
            while(j<balloonNum){
                if(!(arrowPos >= points[j][0] && arrowPos <=points[j][1])){
                    i=j-1;
                    break;
                }
                j++;
            }
            if(j==balloonNum)break;
            i++;
        }
        return arrowNum;
    }
}
