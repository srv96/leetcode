package me.coding.leetcode.code;

import me.coding.ds.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

class Solution49 {
    Set<TreeNode> univalSet;

    public int countUnivalSubtrees(TreeNode root) {
        univalSet = new HashSet<>();
        findUnival(root);
        return univalSet.size();
    }

    private void findUnival(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            univalSet.add(root);
            return;
        }
        if (root.left != null && root.right != null) {
            findUnival(root.left);
            findUnival(root.right);

            if (univalSet.contains(root.left) && univalSet.contains(root.right) && root.val == root.left.val && root.val == root.right.val) {
                univalSet.add(root);
            }
            return;
        }
        if (root.left != null) {
            findUnival(root.left);
            if (univalSet.contains(root.left) && root.val == root.left.val) {
                univalSet.add(root);
            }
            return;
        }
        if (root.right != null) {
            findUnival(root.right);
            if (univalSet.contains(root.right) && root.val == root.right.val) {
                univalSet.add(root);
            }
            return;
        }
    }
}
