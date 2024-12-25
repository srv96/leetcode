package me.coding.company.microsoft;

import me.coding.ds.tree.TreeNode;

import java.util.Arrays;

class Solution20 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int[] idxStore = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            idxStore[nums[i]] = i;
        }
        return cmbt(nums, idxStore, 0, nums.length - 1);
    }

    private TreeNode cmbt(int[] nums, int[] idxStore, int i, int j) {
        if (i < 0 || j >= nums.length || i > j) return null;
        if (i == j) {
            return new TreeNode(nums[i]);
        }

        int max = Arrays.stream(nums, i, j + 1).max().getAsInt();
        int idx = idxStore[max];

        TreeNode node = new TreeNode(nums[idx]);
        node.left = cmbt(nums, idxStore, i, idx - 1);
        node.right = cmbt(nums, idxStore, idx + 1, j);
        return node;
    }
}
