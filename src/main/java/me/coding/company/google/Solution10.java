package me.coding.company.google;

import me.coding.ds.set.DSU;

import java.util.TreeSet;

class Solution10 {
    public int earliestAcq(int[][] logs, int n) {
        DSU dsu = new DSU(n);
        TreeSet<int[]> logsSequence = new TreeSet<>((o1, o2) -> o1[0] - o2[0]);
        int size = logs.length;
        for(int i = 0 ; i < size ; i++){
            logsSequence.add(logs[i]);
        }
        int connectionCount = 0 ;
        while (connectionCount < n-1 && !logsSequence.isEmpty()){
            int[] log = logsSequence.pollFirst();
            if(!dsu.isConnected(log[1],log[2])){
                dsu.union(log[1],log[2]);
                connectionCount++;
            }
            if(connectionCount == n-1)return log[0];
        }
        return -1;
    }
}
