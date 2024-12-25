package me.coding.leetcode.top150;

import me.coding.ds.graph.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution38 {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        if(node.neighbors==null)return new Node(node.val);

        Node head = null;
        Node pivot = node;
        Queue<Node> nodeQueue = new LinkedList<>();
        Map<Node,Node> nodeMap = new HashMap<>();
        Map<Node,Boolean> visited = new HashMap<>();

        nodeQueue.offer(node);
        while(!nodeQueue.isEmpty()){
            Node temp = nodeQueue.poll();
            nodeMap.put(temp,new Node(temp.val));
            visited.put(temp,true);
            for(Node neighbour : temp.neighbors){
                if(visited.get(neighbour)==null)nodeQueue.offer(neighbour);
            }
        }

        for(Node itr : nodeMap.keySet()){
            Node temp = nodeMap.get(itr);
            for(Node neighbour : itr.neighbors){
                temp.neighbors.add(nodeMap.get(neighbour));
            }
        }

        return nodeMap.get(node);
    }
}
