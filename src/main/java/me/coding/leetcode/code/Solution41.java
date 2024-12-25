package me.coding.leetcode.code;

import me.coding.ds.list.ListNode;
import me.coding.ds.tree.TreeNode;

class Solution41 {
    public ListNode[] getMid(ListNode head) {
        if (head == null) return null;
        ListNode[] result = {null, head};
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            result = new ListNode[]{slow, slow.next};
            slow = slow.next;
            fast = fast.next.next;
        }
        return result;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return new TreeNode(head.val);
        ListNode[] mid = getMid(head);
        TreeNode root = new TreeNode(mid[1].val);
        if (mid[0] != null) mid[0].next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid[1].next);
        return root;
    }
}
