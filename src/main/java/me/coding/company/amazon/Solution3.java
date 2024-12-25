package me.coding.company.amazon;

import me.coding.ds.set.DSU;

import java.util.*;

class Solution3 {
    class Edge {
        public int weight;
        public int node;
        public int parent;

        public Edge(int weight, int node, int parent) {
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        PriorityQueue<Edge> allEdge = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    allEdge.add(new Edge(cost(i, j, points), i, j));
                }
            }
        }
        DSU dsu = new DSU(size);
        int edgeCount = 0 ;
        int msCost = 0 ;
        while(edgeCount < size-1 && !allEdge.isEmpty()){
            Edge edge = allEdge.poll();
            if(!dsu.isConnected(edge.node,edge.parent)){
                msCost+=edge.weight;
                dsu.union(edge.node,edge.parent);
                edgeCount++;
            }
        }
        return msCost;
    }

    private int cost(int i, int j, int[][] points) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
