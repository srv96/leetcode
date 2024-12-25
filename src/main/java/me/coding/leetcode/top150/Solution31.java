package me.coding.leetcode.top150;

import me.coding.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution31 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);
        List<Integer> result = new ArrayList<>();
        while (!levelQueue.isEmpty()) {
            int size = levelQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = levelQueue.poll();
                if (i == size - 1) result.add(node.val);
                if (node.left != null) levelQueue.offer(node.left);
                if (node.right != null) levelQueue.offer(node.right);
            }
        }
        return result;
    }
}
