package me.coding.company.walmart;

import me.coding.ds.tree.TreeNode;

class Solution5 {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        int leftMax = 0,rightMax = 0;
        if (root.left != null && root.val + 1 == root.left.val)leftMax = longestConsecutive(root.left);
        if (root.right != null && root.val + 1 == root.right.val)rightMax = longestConsecutive(root.right);
        int rootTotal =  1+Math.max(leftMax,rightMax);
        leftMax = 0;rightMax = 0;
        leftMax = longestConsecutive(root.left);
        rightMax = longestConsecutive(root.right);
        return Math.max(rootTotal,Math.max(leftMax,rightMax));
    }
}
