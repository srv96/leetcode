package me.coding.company.microsoft;

import me.coding.ds.list.ListNode;

import java.util.Stack;

class Solution16 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> ls1 = new Stack<>(), ls2 = new Stack<>(), ls3 = new Stack<>();
        ListNode head = l1;
        while (head != null) {
            ls1.push(head);
            head = head.next;
        }
        head = l2;
        while (head != null) {
            ls2.push(head);
            head = head.next;
        }
        int carry = 0;
        while (!ls1.isEmpty() && !ls2.isEmpty()) {
            int n1 = ls1.pop().val;
            int n2 = ls2.pop().val;
            int sum = (n1 + n2 + carry) % 10;
            carry = (n1 + n2 + carry) / 10;
            ls3.push(new ListNode(sum));
        }
        while (!ls1.isEmpty()) {
            int n1 = ls1.pop().val;
            int sum = (n1 + carry) % 10;
            carry = (n1 + carry) / 10;
            ls3.push(new ListNode(sum));
        }
        while (!ls2.isEmpty()) {
            int n2 = ls2.pop().val;
            int sum = (n2 + carry) % 10;
            carry = (n2 + carry) / 10;
            ls3.push(new ListNode(sum));
        }
        if (carry != 0) {
            ls3.push(new ListNode(carry));
        }
        ListNode result = null, curr = null;
        while (!ls3.isEmpty()) {
            if (result == null) {
                result = ls3.pop();
                curr = result;
            } else {
                curr.next = ls3.pop();
                curr = curr.next;
            }
        }
        return result;
    }
}
