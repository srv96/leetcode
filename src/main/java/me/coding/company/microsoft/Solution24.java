package me.coding.company.microsoft;

import me.coding.ds.pair.Pair;
import me.coding.ds.tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution24 {
    Set<TreeNode> largeBSTSet;
    Map<TreeNode, Integer> treeSizeMap;

    Map<TreeNode, Pair<Integer, Integer>> bigSmallMap;

    public int largestBSTSubtree(TreeNode root) {
        largeBSTSet = new HashSet<>();
        treeSizeMap = new HashMap<>();
        bigSmallMap = new HashMap<>();
        findLargeBST(root);
        int maxSize = 0;
        for (TreeNode node : largeBSTSet) {
            maxSize = Math.max(maxSize, treeSizeMap.get(node));
        }
        return maxSize;
    }

    private void findLargeBST(TreeNode root) {
        if (root == null) return;
        findLargeBST(root.left);
        findLargeBST(root.right);

        if (root.left == null && root.right == null) {
            largeBSTSet.add(root);
            treeSizeMap.put(root, 1);
            bigSmallMap.put(root,new Pair<>(root.val,root.val));
            return;
        }
        if (root.left != null && root.right != null) {
            if (largeBSTSet.contains(root.left) && largeBSTSet.contains(root.right) && root.left.val < root.val && root.right.val > root.val) {
                largeBSTSet.add(root);
                treeSizeMap.put(root, treeSizeMap.get(root.left) + treeSizeMap.get(root.right) + 1);
                bigSmallMap.put(root,new Pair<>(Math.max(root.val,bigSmallMap.get(root.left).value),Math.min(root.val,bigSmallMap.get(root.right).key)));
                bigSmallMap.remove(root.left);
                bigSmallMap.remove(root.right);
                treeSizeMap.remove(root.left);
                treeSizeMap.remove(root.right);
                largeBSTSet.remove(root.left);
                largeBSTSet.remove(root.right);
            }
            return;
        }
        if (root.left != null) {
            if (largeBSTSet.contains(root.left) && root.left.val < root.val) {
                largeBSTSet.add(root);
                treeSizeMap.put(root, treeSizeMap.get(root.left) + 1);
                treeSizeMap.remove(root.left);
                largeBSTSet.remove(root.left);
            }
            return;
        }
        if (root.right != null) {
            if (largeBSTSet.contains(root.right) && root.right.val > root.val) {
                largeBSTSet.add(root);
                treeSizeMap.put(root, treeSizeMap.get(root.right) + 1);
                treeSizeMap.remove(root.right);
                largeBSTSet.remove(root.right);
            }
            return;
        }
    }
}
