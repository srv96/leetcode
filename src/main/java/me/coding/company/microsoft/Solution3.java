package me.coding.company.microsoft;

import me.coding.ds.tree.TreeNode;

import java.util.Stack;

class Solution3 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        boolean found = false;
        if (root == null) return null;
        Stack<TreeNode> inOrderStack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !inOrderStack.isEmpty()) {
            while (curr != null) {
                inOrderStack.push(curr);
                curr = curr.left;
            }
            curr = inOrderStack.pop();
            if(found==true)return curr;
            if(curr.val==p.val){
                found = true;
            }
            curr = curr.right;
        }
        return null;
    }
}
