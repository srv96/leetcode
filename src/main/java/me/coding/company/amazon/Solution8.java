package me.coding.company.amazon;

import me.coding.ds.tree.TreeNode;

class Solution8 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)return null;
        else{
            bstToGst(root.right);
            root.val+=sum;
            sum = root.val;
            bstToGst(root.left);
            return root;
        }
    }
}