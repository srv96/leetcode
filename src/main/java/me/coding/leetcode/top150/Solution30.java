package me.coding.leetcode.top150;

import me.coding.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution30 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!levelQueue.isEmpty()){
            int size = levelQueue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = levelQueue.poll();
                level.add(node.val);
                if(node.left!=null)levelQueue.offer(node.left);
                if(node.right!=null)levelQueue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
