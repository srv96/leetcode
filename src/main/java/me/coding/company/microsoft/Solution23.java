package me.coding.company.microsoft;

import me.coding.ds.tree.narray.Node;

import java.util.ArrayList;

class Solution23 {
    public Node cloneTree(Node root) {
        if (root == null) return null;

        int size = root.children.size();
        ArrayList<Node> children = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            children.add(cloneTree(root.children.get(i)));
        }

        return new Node(root.val, children);
    }
}
