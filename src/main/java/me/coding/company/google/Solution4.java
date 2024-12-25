package me.coding.company.google;

import me.coding.ds.tree.TreeNode;

class Solution4 {
    int count;
    public int averageOfSubtree(TreeNode root) {
        int[] result = dfsTreeSum(root);
        return count;
    }
    private int[] dfsTreeSum(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] leftSum = dfsTreeSum(root.left);
        int[] rightSum = dfsTreeSum(root.right);
        int val = root.val;
        int totalCount = leftSum[1] + rightSum[1] + 1;
        int totalSum = leftSum[0] + rightSum[0] + val;
        if ((int) (totalSum / totalCount) == val) count++;
        return new int[]{totalSum, totalCount};

    }
}
