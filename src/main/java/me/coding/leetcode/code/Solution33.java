package me.coding.leetcode.code;

import me.coding.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution33 {
    class Pair {
        public Pair(int first, TreeNode second) {
            this.first = first;
            this.second = second;
        }

        int first;
        TreeNode second;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Queue<Pair> nodeQueue = new LinkedList<>();
        List<Pair> pairList = new ArrayList<>();
        nodeQueue.add(new Pair(root.val, root));
        while (!nodeQueue.isEmpty()) {
            Pair pair = nodeQueue.poll();
            pairList.add(pair);
            if (pair.second.left != null) {
                nodeQueue.add(new Pair(pair.second.val + pair.second.left.val, pair.second.left));
            }
            if (pair.second.right != null) {
                nodeQueue.add(new Pair(pair.second.val + pair.second.right.val, pair.second.right));
            }
        }
        int count=0;
        for(Pair pair : pairList){
            if(pair.first==targetSum)count++;
        }
        return count;
    }
}
