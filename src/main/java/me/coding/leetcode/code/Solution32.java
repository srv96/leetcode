package me.coding.leetcode.code;

import me.coding.ds.tree.narray.Node;

import java.util.*;

class Solution32 {
    class Pair {
        public Pair(int first, Node second) {
            this.first = first;
            this.second = second;
        }

        int first;
        Node second;
    }

    public List<List<Integer>> levelOrder(Node root) {
        if(root==null){
            List<List<Integer>> empty = new ArrayList<>();
            return empty;
        }
        Queue<Pair> nodeQueue = new LinkedList<>();
        nodeQueue.add(new Pair(0, root));
        List<Pair> pairList = new ArrayList<>();
        int maxLevel = Integer.MIN_VALUE;
        while (!nodeQueue.isEmpty()) {
            Pair pair = nodeQueue.poll();
            maxLevel = Math.max(maxLevel, pair.first);
            pairList.add(pair);
            if (pair.second.children != null) {
                for (Node node : pair.second.children) {
                    nodeQueue.add(new Pair(pair.first + 1, node));
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= maxLevel; i++) {
            result.add(new ArrayList<>());
        }
        for (Pair pair : pairList) {
            result.get(pair.first).add(pair.second.val);
        }
        return result;
    }
}