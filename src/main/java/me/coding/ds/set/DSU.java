package me.coding.ds.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DSU {
    int[] parent, rank;

    public DSU(int capacity) {
        parent = new int[capacity];
        rank = new int[capacity];
        Arrays.fill(rank, 0);
        for (int i = 0; i < capacity; i++) {
            parent[i] = i;
        }
    }

    public void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        int ru = rank[pu];
        int rv = rank[pv];
        if (ru > rv) {
            parent[pv] = pu;
        } else {
            if(ru == rv) rank[pv]++;
            parent[pu] = pv;
        }
    }

    private int findParent(int u) {
        if (u == parent[u]) return u;
        else {
            parent[u] = findParent(parent[u]);
            return parent[u];
        }
    }

    public boolean isConnected(int u, int v) {
        return findParent(u) == findParent(v);
    }

    public int countParent(){
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.stream(parent).boxed().collect(Collectors.toList()));
        return set.size();
    }
}
