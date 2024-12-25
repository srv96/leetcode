package me.coding.company.microsoft;

import me.coding.ds.tree.TreeNode;

import java.util.*;

class Solution22 {
    Map<Integer, List<TreeNode>> treeNodeMemo;

    public List<TreeNode> allPossibleFBT(int n) {
        treeNodeMemo = new HashMap<>();
        for (int i = 1; i <= n; i += 2) {
            treeNodeMemo.put(i, apFBT(i));
        }
        return treeNodeMemo.getOrDefault(n,new ArrayList<>());
    }
    private List<TreeNode> apFBT(int n) {
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(new TreeNode(0)));
        }
        if (n == 3) {
            return new ArrayList<>(Arrays.asList(new TreeNode(0, new TreeNode(0), new TreeNode(0))));
        }
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = new TreeNode(0);
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = treeNodeMemo.get(i);
            List<TreeNode> right = treeNodeMemo.get(n - i - 1);
            int lSize = left.size();
            int rSize = right.size();
            for (int j = 0; j < lSize; j++) {
                for (int k = 0; k < rSize; k++) {
                    node.left = left.get(j);
                    node.right = right.get(k);
                    list.add(snapshot(node));
                }
            }
        }
        return list;
    }
    private TreeNode snapshot(TreeNode node) {
        if (node == null) return null;
        return new TreeNode(node.val, snapshot(node.left), snapshot(node.right));
    }
}
