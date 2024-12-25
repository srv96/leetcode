package me.coding.sandbox;

import me.coding.ds.tree.TreeNode;

public class Solution2 {
    int maxVal;
    public int getMaxSum(TreeNode root){
        maxVal = Integer.MIN_VALUE;
        int result = dfs(root);
        return maxVal;
    }

    private int dfs(TreeNode root) {
        if(root==null)return 0;
        int leftPathSum = dfs(root.left);
        int rightPathSum = dfs(root.right);
        int totalPathSum = leftPathSum+root.val+rightPathSum;
        int temp = Math.max(root.val,Math.max(root.val+leftPathSum, root.val+rightPathSum));
        totalPathSum = Math.max(totalPathSum,temp);
        maxVal = Math.max(maxVal,totalPathSum);
        return Math.max(leftPathSum,rightPathSum)+root.val;
    }
}
