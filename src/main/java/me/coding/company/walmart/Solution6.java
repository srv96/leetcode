package me.coding.company.walmart;

import me.coding.ds.tree.TreeNode;

import java.util.*;

class Solution6 {
    Map<Integer, List<Integer>> relationMap = new HashMap();
    List<Integer> kthNodes = new ArrayList<>();
    boolean[] visitFlag;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return Arrays.asList();
        if (root.left == null && root.right == null && k == 0) return Arrays.asList(root.val);
        if (root.left == null && root.right == null && k > 0) return Arrays.asList();
        traverse(root);
        int targetVal = target.val;
        visitFlag = new boolean[relationMap.size() + 1];
        Arrays.fill(visitFlag, false);
        findKth(targetVal, k);
        return kthNodes;
    }

    private void findKth(int targetVal, int k) {
        if (visitFlag[targetVal] == true) return;

        if (k == 0) {
            kthNodes.add(targetVal);
        } else {
            if (relationMap.get(targetVal) != null) {
                List<Integer> relation = relationMap.get(targetVal);
                for (Integer val : relation) {
                    visitFlag[targetVal] = true;
                    findKth(val, k - 1);
                    visitFlag[targetVal] = false;
                }
            }
        }
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            if (relationMap.get(root.val) == null)
                relationMap.put(root.val, new ArrayList<>(Arrays.asList(root.left.val)));
            else {
                List<Integer> relation = relationMap.get(root.val);
                relation.add(root.left.val);
            }

            if (relationMap.get(root.left.val) == null)
                relationMap.put(root.left.val, new ArrayList<>(Arrays.asList(root.val)));
            else {
                List<Integer> relation = relationMap.get(root.left.val);
                relation.add(root.val);
            }
        }
        if (root.right != null) {
            if (relationMap.get(root.val) == null)
                relationMap.put(root.val, new ArrayList<>(Arrays.asList(root.right.val)));
            else {
                List<Integer> relation = relationMap.get(root.val);
                relation.add(root.right.val);
            }

            if (relationMap.get(root.right.val) == null)
                relationMap.put(root.right.val, new ArrayList<>(Arrays.asList(root.val)));
            else {
                List<Integer> relation = relationMap.get(root.right.val);
                relation.add(root.val);
            }
        }
        traverse(root.left);
        traverse(root.right);
    }
}
