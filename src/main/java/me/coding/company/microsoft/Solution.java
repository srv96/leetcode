package me.coding.company.microsoft;

import me.coding.ds.list.ListNode;

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head.next, sum = head;
        int sumNum = 0;
        while (curr != null) {
            if (curr.val != 0) {
                sum.val += curr.val;
                curr = curr.next;
            } else {
                sum.next = curr;
                sum = sum.next;
                curr = curr.next;
            }
        }
        curr = head;
        while (curr.next.val != 0) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }
}