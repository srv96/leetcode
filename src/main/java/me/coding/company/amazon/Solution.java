package me.coding.company.amazon;


import me.coding.ds.tree.TreeNode;

class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode node = findParent(root, target);
        if (node == null) return new TreeNode[]{root, null};
        if (root.left.val == target) {
            TreeNode first = root.left;
            root.left = root.left.right;
            first.right = null;
            return new TreeNode[]{first, root};
        }
        if (root.right.val == target) {
            TreeNode second = root.right;
            root.right = root.right.left;
            second.left = null;
            return new TreeNode[]{root, second};
        }
        return null;
    }

    private TreeNode findParent(TreeNode root, int target) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return null;
        if ((root.left != null && root.left.val == target) || (root.right != null && root.right.val == target))
            return root;
        if (root.val > target) return findParent(root.left, target);
        if (root.val < target) return findParent(root.right, target);
        return null;
    }
}
