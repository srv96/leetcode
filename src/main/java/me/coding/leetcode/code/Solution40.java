package me.coding.leetcode.code;

import me.coding.ds.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution40 {
    public int deepestLeavesSum(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            int result = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                int sum = 0;
                for(int i = 0 ; i < size ; i++){
                    TreeNode node = queue.poll();
                    sum+=node.val;
                    if(node.left!=null)queue.add(node.left);
                    if(node.right!=null)queue.add(node.right);
                }
                result=sum;
            }
            return result;
    }
}
