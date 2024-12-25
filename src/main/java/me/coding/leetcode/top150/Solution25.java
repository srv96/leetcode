package me.coding.leetcode.top150;

import me.coding.ds.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

class Solution25 {
    public Node connect(Node root) {
        if(root==null || (root.left==null&&root.right==null))return root;

        Queue<Node> levelQueue = new LinkedList<>();
        levelQueue.offer(root);

        while(!levelQueue.isEmpty()){
            int levelSize = levelQueue.size();
            for(int i = 0 ; i < levelSize ; i++){
                if(i==levelSize-1){
                    Node node = levelQueue.poll();
                    if(node.left!=null)levelQueue.offer(node.left);
                    if(node.right!=null)levelQueue.offer(node.right);
                }
                else{
                    Node node = levelQueue.poll();
                    node.next = levelQueue.peek();
                    if(node.left!=null)levelQueue.offer(node.left);
                    if(node.right!=null)levelQueue.offer(node.right);
                }
            }
        }
        return root;
    }
}
