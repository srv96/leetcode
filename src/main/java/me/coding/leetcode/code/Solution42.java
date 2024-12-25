package me.coding.leetcode.code;

import me.coding.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution42 {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, path, 0, targetSum);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> path, int sum, int targetSum) {
        if (root == null) return;
        else {
            if (root.left == null && root.right == null) {
                if (sum + root.val == targetSum) {
                    result.add(new ArrayList<>(path));
                }
            } else {
                if(root.left!=null){
                    path.add(root.left.val);
                    dfs(root.left, path, sum + root.val, targetSum);
                    path.remove(path.size()-1);
                }
                if(root.right!=null){
                    path.add(root.right.val);
                    dfs(root.right, path, sum + root.val, targetSum);
                    path.remove(path.size()-1);
                }
            }
        }
    }
}
//path.add(root.val);
//            if (root.left == null && root.right == null) {
//dfs(null, path, sum + root.val, targetSum);
//            } else {
//dfs(root.left, path, sum + root.val, targetSum);
//dfs(root.right, path, sum + root.val, targetSum);
//            }
//                    path.remove(path.size() - 1);