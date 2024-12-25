package me.coding.company.microsoft;

import me.coding.ds.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution19 {
    Map<TreeNode, Integer> largestMap;
    Map<TreeNode, Integer> smallestMap;
    Map<TreeNode, Integer> nodeCount;

    public int largestBSTSubtree(TreeNode root) {
        largestMap = new HashMap<>();
        smallestMap = new HashMap<>();
        nodeCount = new HashMap<>();
        return lBstCount(root);

    }

    private int lBstCount(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;

        if (root.left != null && findLargest(root.left) < root.val && root.right != null && findSmallest(root.right) > root.val)
            return countNode(root);
        if (root.right == null && findLargest(root.left) < root.val) return countNode(root);
        if (root.left == null && findSmallest(root.right) > root.val) return countNode(root);
        if (root.left != null && findLargest(root.left) < root.val && root.right != null && findSmallest(root.right) > root.val)
            return countNode(root);
        return Math.max(lBstCount(root.left), lBstCount(root.right));
    }

    private int countNode(TreeNode root) {
        if (root == null) return 0;
        if (nodeCount.containsKey(root)) return nodeCount.get(root);
        int lCount = countNode(root.left);
        int rCount = countNode(root.right);
        nodeCount.put(root, lCount + rCount + 1);
        return nodeCount.get(root);
    }

    private int findLargest(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        if (largestMap.containsKey(root)) return largestMap.get(root);
        int lMax = findLargest(root.left);
        int rMax = findLargest(root.right);
        largestMap.put(root, Math.max(root.val, Math.max(lMax, rMax)));
        return largestMap.get(root);
    }

    private int findSmallest(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (smallestMap.containsKey(root)) return smallestMap.get(root);
        int lMin = findSmallest(root.left);
        int rMin = findSmallest(root.right);
        smallestMap.put(root, Math.min(root.val, Math.min(lMin, rMin)));
        return smallestMap.get(root);
    }
}