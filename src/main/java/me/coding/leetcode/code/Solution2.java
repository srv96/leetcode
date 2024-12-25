//package me.coding.leetcode.code;
//
//
//import java.util.*;
//
//public class Solution2 {
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        Map<Integer,TreeGraphViewNode> graphView = getGraphViewFromTree(root);
//    }
//
//    private Map<Integer, TreeGraphViewNode> getGraphViewFromTree(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        Map<Integer, TreeGraphViewNode> treeGraph = new HashMap<>();
//        TreeGraphViewNode gRoot = new TreeGraphViewNode(root.val);
//        if(root.left!=null)gRoot.left=new TreeGraphViewNode(root.left.val);
//        if(root.right!=null)gRoot.right=new TreeGraphViewNode(root.right.val);
//        gRoot.top=null;
//        treeGraph.put(gRoot.val,gRoot);
//        while (!queue.isEmpty()){
//            TreeNode front =  queue.poll();
//            if(root.left!=null)gRoot.left=new TreeGraphViewNode(root.left.val);
//            if(root.right!=null)gRoot.right=new TreeGraphViewNode(root.right.val);
//        }
//    }
//}
