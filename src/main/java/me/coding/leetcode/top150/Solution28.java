package me.coding.leetcode.top150;

import me.coding.ds.tree.TreeNode;

class Solution28 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;

        if(root.val==p.val)return root;
        if(root.val==q.val)return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left==null && right==null)return null;
        if(left!=null && right==null)return left;
        if(left==null && right!=null)return right;
        if(left!=null && right!=null)return root;

        return null;
    }
}
