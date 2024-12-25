package me.coding.ds.list;

import java.util.ArrayList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode fromArrayList(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        ListNode head = new ListNode(list.get(0));
        ListNode current = head;

        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }

        return head;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            result.append(current.val).append(" -> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }
}
