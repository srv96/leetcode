package me.coding.leetcode.top150;

import me.coding.ds.tree.TreeNode;

import java.util.Stack;

class BSTIterator {
    TreeNode root;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.root = root;
        pushLeft(root);
    }

    public int next() {
        TreeNode next = stack.pop();
        pushLeft(next.right);
        return next.val;
    }

    public boolean hasNext() {
        return stack.isEmpty() ? false : true;
    }

    public void pushLeft(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }
}
