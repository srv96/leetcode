package me.coding.leetcode.code;

import me.coding.ds.tree.TreeNode;

class Solution14 {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null){
            if(root.val==val)return root;
            else if(root.val < val)root = root.right;
            else root = root.left;
        }
        return root;
    }
}
