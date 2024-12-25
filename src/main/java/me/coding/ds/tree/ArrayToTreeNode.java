package me.coding.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayToTreeNode {

    public static TreeNode convertToBinaryTree(ArrayList<Integer> arr) {
        if (arr == null || arr.isEmpty())
            return null;

        TreeNode root = new TreeNode(arr.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.size()) {
            TreeNode current = queue.poll();

            Integer leftVal = (i < arr.size()) ? arr.get(i) : null;
            Integer rightVal = (i + 1 < arr.size()) ? arr.get(i + 1) : null;

            if (leftVal != null) {
                current.left = new TreeNode(leftVal);
                queue.offer(current.left);
            }

            if (rightVal != null) {
                current.right = new TreeNode(rightVal);
                queue.offer(current.right);
            }

            i += 2;
        }

        return root;
    }

    // Utility function to print the binary tree using inorder traversal
    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}

