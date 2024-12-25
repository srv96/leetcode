package me.coding.company.google;

import me.coding.ds.tree.TreeNode;

class Solution28 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val) return p;
        if (root.val == q.val) return q;
        boolean left1 = findNode(root.left, p);
        boolean left2 = findNode(root.left, q);
        boolean right1 = findNode(root.right, p);
        boolean right2 = findNode(root.right, q);
        if (left1 && right2 || left2 && right1) return root;
        if (left1 && left2) return lowestCommonAncestor(root.left, p, q);
        if (right1 && right2) return lowestCommonAncestor(root.right, p, q);
        else return null;
    }

    private boolean findNode(TreeNode root, TreeNode child) {
        if (root == null) return false;
        if (root.val == child.val) return true;
        else {
            return findNode(root.left, child) || findNode(root.right, child);
        }
    }
}
