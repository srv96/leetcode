package me.coding.company.microsoft;

import me.coding.ds.tree.TreeNode;

class Solution10 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        else {
            if (root.val > val) {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                } else {
                    insertIntoBST(root.left, val);
                }
            } else {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                } else {
                    insertIntoBST(root.right, val);
                }
            }
            return root;
        }
    }
}
