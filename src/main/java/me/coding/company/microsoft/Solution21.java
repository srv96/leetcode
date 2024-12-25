package me.coding.company.microsoft;

import me.coding.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution21 {
    List<Integer> sortedList;

    public TreeNode balanceBST(TreeNode root) {
        sortedList = new ArrayList<>();
        inorder(root);
        return buildTree(sortedList, 0, sortedList.size() - 1);
    }

    private TreeNode buildTree(List<Integer> sortedList, int i, int j) {
        if (i < 0 || j >= sortedList.size() || i > j) return null;
        if (i == j) {
            return new TreeNode(sortedList.get(i));
        }
        int mid = (i + j) / 2;
        return new TreeNode(sortedList.get(mid),buildTree(sortedList, i, mid - 1),buildTree(sortedList, mid + 1, j));
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        sortedList.add(root.val);
        inorder(root.right);
    }
}
