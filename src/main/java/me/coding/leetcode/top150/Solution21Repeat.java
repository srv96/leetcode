package me.coding.leetcode.top150;

import me.coding.ds.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution21Repeat {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        int preLength = preorder.length;
        int inLength = inorder.length;

        for (int i = 0; i < inLength; i++) {
            inOrderMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preLength-1, inorder, 0, inLength-1, inOrderMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {

        if(preStart > preEnd || inStart > inEnd)return null;

        int val = preorder[preStart];
        int inRoot = inMap.get(val);
        int numsLeft = inRoot-inStart;

        TreeNode root = new TreeNode(val);
        root.left = buildTree(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,inMap);
        root.right = buildTree(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,preEnd,inMap);
        return root;

    }
}
