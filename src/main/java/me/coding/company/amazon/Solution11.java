package me.coding.company.amazon;

import me.coding.ds.tree.TreeNode;

class Solution11 {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        else {
            if (root.left != null && root.right != null) {
                if (root.val >= root.left.val && root.val <= root.right.val)
                    return 1 + largestBSTSubtree(root.left) + largestBSTSubtree(root.right);
                if(root.val >= root.left.val)
                    return 1 + largestBSTSubtree(root.left);
                if(root.val <= root.right.val)
                    return 1 + largestBSTSubtree(root.right);
            }
            if (root.left == null) {
                if(root.val <= root.right.val)
                    return 1 + largestBSTSubtree(root.right);
            }
            if (root.right == null) {
                if(root.val >= root.left.val)
                    return 1 + largestBSTSubtree(root.left);
            }
            else return 1;
        }
        return 1;
    }
}
