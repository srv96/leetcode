package me.coding.company.google;

import me.coding.ds.tree.TreeNode;

import java.util.*;

class Solution27 {
    Map<TreeNode, Integer> level;
    int maxLevel;

    public List<List<Integer>> findLeaves(TreeNode root) {
        level = new HashMap<>();
        maxLevel = Integer.MIN_VALUE;
        fl(root, level);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= maxLevel; i++) {
            result.add(new ArrayList<>());
        }
        for (TreeNode node : level.keySet()) {
            result.get(level.get(node)).add(node.val);
        }
        return result;
    }

    private void fl(TreeNode root, Map<TreeNode, Integer> level) {
        if (root == null) return;

        fl(root.left, level);
        fl(root.right, level);

        if (root.left == null && root.right == null) {
            level.put(root, 0);
            maxLevel = Math.max(maxLevel, 0);
        }

        int lvl = 1 + Math.max(level.getOrDefault(root.left, -1), level.getOrDefault(root.right, -1));
        maxLevel = Math.max(maxLevel, lvl);
        level.put(root, lvl);
    }
}