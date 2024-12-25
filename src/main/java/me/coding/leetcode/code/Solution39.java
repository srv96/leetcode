package me.coding.leetcode.code;

import me.coding.ds.tree.TreeNode;

import java.util.*;

class Solution39 {
    Map<Integer, List<TreeNode>> memo;

    public Solution39() {
        memo = new HashMap<>();
        List<TreeNode> val = new ArrayList<>();
        val.add(null);
        memo.put(0, val);
        List<TreeNode> result = new ArrayList<>(List.of(new TreeNode(1)));
        memo.put(1, result);
        memo.put(2, new ArrayList<>(List.of(new TreeNode(1, null, new TreeNode(2)), new TreeNode(2, new TreeNode(1), null))));
    }

    private List<TreeNode> modifyTrees(List<TreeNode> generateTrees, int idx) {
        int size = generateTrees.size();
        List<TreeNode> modifyTree = copyTreeNodeArrayList(generateTrees);
        for (int i = 0; i < size; i++) {
            TreeNode root = modifyTree.get(i);
            addValue(root, idx);
        }
        return modifyTree;
    }

    private void addValue(TreeNode root, int idx) {
        if (root == null) return;
        root.val += idx;
        addValue(root.left, idx);
        addValue(root.right, idx);
    }

    private List<TreeNode> copyTreeNodeArrayList(List<TreeNode> originalList) {
        List<TreeNode> copiedList = new ArrayList<>();
        for (TreeNode originalNode : originalList) {
            TreeNode copiedNode = copyTreeNode(originalNode);
            copiedList.add(copiedNode);
        }
        return copiedList;
    }

    private TreeNode copyTreeNode(TreeNode originalNode) {
        if (originalNode == null) {
            return null;
        }
        TreeNode copiedNode = new TreeNode(originalNode.val);
        copiedNode.left = copyTreeNode(originalNode.left);
        copiedNode.right = copyTreeNode(originalNode.right);
        return copiedNode;
    }

    public List<TreeNode> generateTrees(int n) {
        if (!memo.containsKey(n)) {
            List<TreeNode> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                List<TreeNode> leftSides = generateTrees(i - 1);
                List<TreeNode> rightSides = modifyTrees(generateTrees(n - i), i);
                int leftSize = leftSides.size();
                int rightSize = rightSides.size();
                for (int j = 0; j < leftSize; j++) {
                    for (int k = 0; k < rightSize; k++) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftSides.get(j);
                        root.right = rightSides.get(k);
                        result.add(root);
                    }
                }
            }
            memo.put(n, result);
        }
        return memo.get(n);
    }
}
