package me.coding.ds.tree.narray;

import me.coding.ds.tree.TreeNode;

import java.io.FileWriter;
import java.io.IOException;

public class TreeVisualizer {
    public static void visualize(TreeNode root) {
        StringBuilder dot = new StringBuilder();
        dot.append("digraph Tree {\n");
        generateDOT(root, dot);
        dot.append("}");

        try {
            FileWriter writer = new FileWriter("tree.dot");
            writer.write(dot.toString());
            writer.close();
            System.out.println("DOT file generated successfully: tree.dot");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateDOT(TreeNode node, StringBuilder dot) {
        if (node != null) {
            if (node.left != null) {
                dot.append(node.val).append(" -> ").append(node.left.val).append(";\n");
                generateDOT(node.left, dot);
            }
            if (node.right != null) {
                dot.append(node.val).append(" -> ").append(node.right.val).append(";\n");
                generateDOT(node.right, dot);
            }
        }
    }
}
