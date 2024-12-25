package me.coding.company.google;


import me.coding.ds.tree.TreeNode;

import java.util.Arrays;

class Solution36 {
    int counter = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        return getBST(preorder, this.counter, inorder, 0, inorder.length - 1);
    }

    private TreeNode getBST(int[] preorder, int counter, int[] inorder, int left, int right) {
        if (this.counter >= preorder.length || left > right) return null;
        if (left == right) {
            return new TreeNode(preorder[this.counter]);
        }

        TreeNode root = new TreeNode(preorder[this.counter]);
        int idx = findIdx(inorder, left, right, preorder[this.counter]);
        if (left <= idx - 1) this.counter++;
        root.left = getBST(preorder, this.counter, inorder, left, idx - 1);
        if (idx + 1 <= right) this.counter++;
        root.right = getBST(preorder, this.counter, inorder, idx + 1, right);
        return root;
    }

    private int findIdx(int[] inorder, int left, int right, int mid) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == mid) return i;
        }
        return -1;
    }
}
