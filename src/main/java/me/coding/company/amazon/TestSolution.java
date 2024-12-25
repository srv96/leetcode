package me.coding.company.amazon;

import me.coding.ds.tree.ArrayToTreeNode;
import me.coding.ds.tree.TreeNode;
import me.coding.ds.tree.narray.TreeVisualizer;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        TreeNode root = ArrayToTreeNode.convertToBinaryTree(new ArrayList<>(Arrays.asList(10,5,20,3,9,15,25,null,null,8,null,null,null,null,null,6,null,null,7)));
        TreeVisualizer.visualize(root);
//        TreeNode[] result = new Solution().splitBST(root,6);
//        System.out.println(result);
    }
}
