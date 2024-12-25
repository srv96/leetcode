package me.coding.company.google;

import me.coding.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution23 {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int rowLength = (int) (Math.pow(2, height) - 1);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            result.add(new ArrayList<>(Collections.nCopies(rowLength, "")));
        }
        putTree(root, result, 0, 0, rowLength);
        return result;
    }

    private void putTree(TreeNode root, List<List<String>> result, int level, int left, int right) {
        if (root == null) return;
        else {
            int mid = (left + right) / 2;
            result.get(level).set(mid, String.valueOf(root.val));
            putTree(root.left, result, level + 1, left, mid);
            putTree(root.right, result, level + 1, mid, right);
        }
    }

    private int getHeight(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
