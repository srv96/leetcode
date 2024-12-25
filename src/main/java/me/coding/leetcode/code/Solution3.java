package me.coding.leetcode.code;

import me.coding.ds.tree.TreeNode;

import java.util.*;

class Solution3 {
    public void getLevelMap(TreeNode root, Map<TreeNode, Integer> levelMap, int level) {
        if (root == null) return;
        else {
            levelMap.put(root, level);
            getLevelMap(root.left, levelMap, level + 1);
            getLevelMap(root.right, levelMap, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        getLevelMap(root, levelMap, 0);
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = levelMap.get(node);
            if(result.size()<=level)result.add(new ArrayList<>());
            List<Integer> row = result.get(level);
            row.add(node.val);
            result.set(level,row);
            if(node.left!=null)queue.add(node.left);
            if(node.right!=null)queue.add(node.right);
        }
        return result;
    }


    public TreeNode getTree() {
        TreeNode tn = new TreeNode(
                3,
                new TreeNode(9, null, null)
                , new TreeNode(20,
                new TreeNode(15, null, null)
                , new TreeNode(7, null, null)
        ));
        return tn;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        TreeNode tn = s.getTree();
        List<List<Integer>> result = s.levelOrder(tn);
        Integer n = new Integer(6);

    }
}
