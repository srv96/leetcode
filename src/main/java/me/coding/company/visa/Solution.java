package me.coding.company.visa;

import me.coding.ds.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<TreeNode, Integer> maxDepth, maxDim;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth = new HashMap<>();
        maxDim = new HashMap<>();
        if(root.left==null && root.right==null)return 0;
        return findMaxDim(root);
    }

    private int findMaxDim(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        if (!maxDim.containsKey(root)) {

            int lMax = findMaxDim(root.left);
            int rMax = findMaxDim(root.right);

            int mLeftD = maxDepth(root.left);
            int mRightD = maxDepth(root.right);

            int total = mLeftD + mRightD;
            maxDim.put(root, Math.max(total, Math.max(lMax, rMax)));
        }

        return maxDim.get(root);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        if (!maxDepth.containsKey(root)) {
            maxDepth.put(root, 1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
        }

        return maxDepth.get(root);
    }
}
