package me.coding.company.flipkart;

import me.coding.ds.tree.ArrayToTreeNode;
import me.coding.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        TreeNode root = ArrayToTreeNode.convertToBinaryTree(new ArrayList<>(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,5,1)));
        System.out.println(new Solution().pathSum(root,22));
    }
}
