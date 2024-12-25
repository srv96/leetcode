package me.coding.leetcode.top150;

import me.coding.ds.list.ListNode;

import java.util.Stack;

class Solution15 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        Stack<ListNode> stack = new Stack<>();

        ListNode pivot = dummyHead;
        ListNode preLeft = null, leftNode = null, postRight = null;
        boolean reverseFlag = false;
        while (pivot != null) {
            if (pivot.next != null && pivot.next.val == left) {
                preLeft = pivot;
                pivot = pivot.next;
                reverseFlag = true;
                continue;
            }
            if (pivot.val == right) {
                stack.push(pivot);
                postRight = pivot.next;
                reverseFlag = false;
                pivot = pivot.next;
                continue;
            }
            if (reverseFlag) {
                stack.push(pivot);
                pivot = pivot.next;
                continue;
            }
            pivot = pivot.next;
        }
        pivot = preLeft;
        while(!stack.isEmpty()){
            pivot.next=stack.pop();
            pivot = pivot.next;
        }
        if(pivot!=null)pivot.next=postRight;
        return dummyHead.next;
    }
}
