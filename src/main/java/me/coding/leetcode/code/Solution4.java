package me.coding.leetcode.code;

import me.coding.ds.tree.TreeNode;

class Solution4 {

    public int diameter(TreeNode root, int diameter) {
        if (root == null) return 0;
        else {
            if (root.left == null && root.right == null) return 0;
            else {
                if (root.right == null) {
                    return Math.max(diameter(root.left, diameter) + 1, height(root,0));
                } else if (root.left == null) {
                    return Math.max(diameter(root.right, diameter) + 1,  height(root,0));
                } else {
                    return Math.max(diameter(root.left,diameter) + diameter(root.right,diameter) + 2,height(root,0));
                }
            }
        }
    }

    public int height(TreeNode root, int level) {
        if (root == null) return level;
        else {
            if (root.left == null && root.right == null) return 1 + level;
            else {
                return Math.max(height(root.left, level), height(root.right, level));
            }
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root, 0)-1;
    }


    public TreeNode getTree() {
        TreeNode tn = new TreeNode(
                1,
                new TreeNode(2,
                        new TreeNode(4, null, null)
                        , new TreeNode(5, null, null))
                , new TreeNode(3, null, null
        ));
        return tn;
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        TreeNode tn = s.getTree();
        int result = s.diameterOfBinaryTree(tn);
    }
}
