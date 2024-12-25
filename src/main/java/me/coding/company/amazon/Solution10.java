package me.coding.company.amazon;

import me.coding.ds.tree.TreeNode;

class Solution10 {
    public String tree2str(TreeNode root) {
        StringBuilder result = getString(root);
        return result.substring(1,result.length()-1);
    }

    private StringBuilder getString(TreeNode root) {
        if (root == null) return new StringBuilder("");
        else {
            StringBuilder leftString  = getString(root.left);
            StringBuilder rightString = getString(root.right);
            if(!rightString.equals("")){
                leftString = !leftString.equals("") ? leftString : new StringBuilder("()");
            }
            return new StringBuilder("(").append(root.val).append(leftString).append(rightString).append(")");
        }
    }
}
