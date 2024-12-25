package me.coding.company.adobe;

import me.coding.ds.tree.TreeNode;

import java.util.*;

public class Solution3 {
    class NodeRow {
        public TreeNode node;
        public int idx;

        public NodeRow(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    Map<Integer, Integer> maxFromRow = new HashMap<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<NodeRow> queue = new LinkedList<>();
        queue.add(new NodeRow(root, 0));
        while (!queue.isEmpty()) {
            NodeRow nodeRow = queue.poll();
            if (!maxFromRow.containsKey(nodeRow.idx)) maxFromRow.put(nodeRow.idx, nodeRow.node.val);
            else maxFromRow.put(nodeRow.idx, Math.max(maxFromRow.get(nodeRow.idx), nodeRow.node.val));

            if (nodeRow.node.left != null) queue.add(new NodeRow(nodeRow.node.left, nodeRow.idx + 1));
            if (nodeRow.node.right != null) queue.add(new NodeRow(nodeRow.node.right, nodeRow.idx + 1));
        }
        Set<Integer> keys = maxFromRow.keySet();
        List<Integer> result = new ArrayList<>();
        for (Integer key : keys) {
            result.add(maxFromRow.get(key));
        }
        return result;
    }
}
