package me.coding.leetcode.top150;

import me.coding.ds.tree.TreeNode;

class Solution26 {
    public int sumNumbers(TreeNode root) {
        return getAllPaths(root, 0)/2;
    }

    private int getAllPaths(TreeNode root, int pathNum) {
        if (root == null) return pathNum;
        pathNum = pathNum * 10 + root.val;

        if (root.left == null && root.right == null)return pathNum;
        if (root.left == null && root.right != null) return getAllPaths(root.right, pathNum);
        if (root.left != null && root.right == null) return getAllPaths(root.left, pathNum);

        return getAllPaths(root.left, pathNum)+getAllPaths(root.right, pathNum);
    }
}
