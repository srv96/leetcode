package me.coding.leetcode.top150;

import me.coding.ds.tree.TreeNode;

class Solution24 {
    public TreeNode flat(TreeNode root){
        if(root == null)return null;
        if(root.left==null&&root.right==null)return root;
        if(root.left!=null&&root.right==null){
            root.left = flat(root.left);
            root.right = root.left;
            root.left = null;
            return root;
        }
        if(root.left==null&root.right!=null){
            root.right = flat(root.right);
            return root;
        }
        if(root.left!=null && root.right!=null){
            root.left = flat(root.left);
            TreeNode temp = flat(root.right);
            root.right = root.left;
            root.left = null;
            TreeNode leaf = root.right;
            while(leaf.right!=null)leaf = leaf.right;
            leaf.right = temp;
            return root;
        }
        else return null;
    }

    public void flatten(TreeNode root) {
        root = flat(root);
    }
}
