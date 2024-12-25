package me.coding.company.google;

import java.util.*;

class Solution32 {
    public int findChampion(int n, int[][] edges) {
        if (n == 1) return 0;
        Set<Integer> allVer = new HashSet<>();
        for (int i = 0; i < n; i++) {
            allVer.add(i);
        }
        Set<Integer> weaker = new HashSet<>();
        Set<Integer> strongest = new HashSet<>();

        int len = edges.length;
        for (int i = 0; i < len; i++) {
            if (strongest.contains(edges[i][1])) {
                strongest.remove(edges[i][1]);
            }
            if (allVer.contains(edges[i][0])) allVer.remove(edges[i][0]);
            if (allVer.contains(edges[i][1])) allVer.remove(edges[i][1]);
            weaker.add(edges[i][1]);
            if (!weaker.contains(edges[i][0])) strongest.add(edges[i][0]);
        }
        if (!allVer.isEmpty() || strongest.size() != 1) return -1;
        else return strongest.stream().mapToInt(Integer::intValue).toArray()[0];
    }
}
