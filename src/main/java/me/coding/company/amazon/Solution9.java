package me.coding.company.amazon;

import me.coding.ds.tree.TreeGraphViewNode;

import java.util.HashSet;
import java.util.Set;

class Solution9 {
    public TreeGraphViewNode lowestCommonAncestor(TreeGraphViewNode p, TreeGraphViewNode q) {
        Set<TreeGraphViewNode> nodes = new HashSet<>();
        TreeGraphViewNode node = p;
        while (node != null) {
            nodes.add(node);
            node = node.top;
        }
        node = q;
        while (node != null) {
            if (nodes.contains(node)) return node;
            else {
                node = node.top;
            }
        }
        return null;
    }
}
