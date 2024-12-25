package me.coding.company.visa;

import me.coding.ds.tree.ArrayToTreeNode;
import me.coding.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        TreeNode root = ArrayToTreeNode.convertToBinaryTree(new ArrayList<>(Arrays.asList(1)));
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
}
