package me.coding.company.flipkart;

import me.coding.ds.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<TreeNode> set = new HashSet<>();

    public int pathSum(TreeNode root, int targetSum) {
        pathSum(root, 0, targetSum);
        return set.size();
    }

    private void pathSum(TreeNode root, int sum, int targetSum) {
        if (root == null) return;
        sum += root.val;
        if (sum == targetSum) {
            set.add(root);
        } else {
            pathSum(root.left, sum, targetSum);
            pathSum(root.left, 0, targetSum);
            pathSum(root.right, sum, targetSum);
            pathSum(root.right, 0, targetSum);
        }
    }
}
