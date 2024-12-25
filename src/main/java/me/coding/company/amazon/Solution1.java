package me.coding.company.amazon;

import me.coding.ds.tree.TreeNode;

import java.util.*;

class Solution1 {
    class NodeColumn{
        public TreeNode node;
        public int idx;

        public NodeColumn(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
    Map<Integer,List<Integer>> nodeCollect;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        nodeCollect = new HashMap<>();
        Queue<NodeColumn> queue = new LinkedList<>();
        queue.add(new NodeColumn(root,0));
        while(!queue.isEmpty()){
            NodeColumn node = queue.poll();
            if(!nodeCollect.containsKey(node.idx)){
                nodeCollect.put(node.idx,new ArrayList<>(List.of(node.node.val)));
            }else{
                List<Integer> vals = nodeCollect.get(node.idx);
                vals.add(node.node.val);
                nodeCollect.put(node.idx,vals);
            }
            if(node.node.left!=null)queue.add(new NodeColumn(node.node.left,node.idx-1));
            if(node.node.right!=null)queue.add(new NodeColumn(node.node.right,node.idx+1));
        }
        List<Integer> keys = new ArrayList<>(nodeCollect.keySet());
        keys.sort(Comparator.naturalOrder());
        List<List<Integer>> result = new ArrayList<>();
        for(Integer key : keys){
            result.add(nodeCollect.get(key));
        }
        return result;
    }
}
