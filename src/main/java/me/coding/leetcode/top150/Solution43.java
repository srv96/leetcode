package me.coding.leetcode.top150;

import java.util.List;

class Solution43 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int leafLevel = triangle.size() - 1;
        for (int level = leafLevel; level > 0; level--) {
            List<Integer> levelNodes = triangle.get(level - 1);
            for (int nodeIdx = 0; nodeIdx < triangle.get(level - 1).size(); nodeIdx++) {
                levelNodes.set(nodeIdx,levelNodes.get(nodeIdx)+Math.min(triangle.get(level).get(nodeIdx),triangle.get(level).get(nodeIdx+1)));
            }
            triangle.set(level-1,levelNodes);
        }
        return triangle.get(0).get(0);
    }
}
