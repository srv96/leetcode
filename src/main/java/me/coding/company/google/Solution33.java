package me.coding.company.google;

import me.coding.ds.set.DSU;

class Solution33 {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int maxV = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            maxV = Math.max(maxV, Math.max(edges[i][0], edges[i][1]));
        }
        DSU set = new DSU(maxV + 1);
        for (int i = 0; i < len; i++) {
            if (set.isConnected(edges[i][0], edges[i][1])) return edges[i];
            set.union(edges[i][0], edges[i][1]);
        }
        return null;
    }
}
