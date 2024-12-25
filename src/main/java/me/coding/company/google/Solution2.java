package me.coding.company.google;

import me.coding.ds.tree.TreeNode;

import java.util.*;

class Solution2 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        result.add(root);
        int size = to_delete.length;
        for (int i = 0; i < size; i++) {
            deleteNode(result, to_delete[i]);
        }
        return result;
    }

    private void deleteNode(List<TreeNode> result, int val) {
        int isRootIdx = isRoot(result, val);
        if (isRootIdx != -1) {
            TreeNode temp = result.get(isRootIdx);
            result.remove(isRootIdx);
            if (temp.left != null) result.add(temp.left);
            if (temp.right != null) result.add(temp.right);
        } else {
            TreeNode parent = findParent(result, val);
            if (parent != null) {
                if (parent.left != null && parent.left.val == val) {
                    TreeNode temp = parent.left;
                    parent.left = null;
                    if (temp.left != null) result.add(temp.left);
                    if (temp.right != null) result.add(temp.right);
                }
                if (parent.right != null && parent.right.val == val) {
                    TreeNode temp = parent.right;
                    parent.right = null;
                    if (temp.left != null) result.add(temp.left);
                    if (temp.right != null) result.add(temp.right);
                }
            }
        }
    }

    private TreeNode findParent(List<TreeNode> result, int val) {
        int size = result.size();
        TreeNode parent = null;
        for (int i = 0; i < size; i++) {
            parent = findParent(result.get(i), val);
            if (parent != null) break;
        }
        return parent;
    }

    private TreeNode findParent(TreeNode root, int val) {
        if (root == null) return null;
        else {
            if ((root.left != null && root.left.val == val) || (root.right != null && root.right.val == val))
                return root;
            else {
                TreeNode subRoot = null;
                if (root.left != null) subRoot = findParent(root.left, val);
                if (subRoot == null) {
                    if (root.right != null) subRoot = findParent(root.right, val);
                }
                return subRoot;
            }
        }
    }

    private int isRoot(List<TreeNode> result, int val) {
        int size = result.size();
        for (int i = 0; i < size; i++) {
            if (result.get(i).val == val) return i;
        }
        return -1;
    }
}
