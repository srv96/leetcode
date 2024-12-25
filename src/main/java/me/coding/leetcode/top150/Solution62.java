package me.coding.leetcode.top150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution62 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int size = edges.size();
        Set<Integer> inVertices = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) inVertices.add(edges.get(i).get(1));
        for (int i = 0; i < n; i++) if (!inVertices.contains(i)) result.add(i);
        return result;
    }
}
