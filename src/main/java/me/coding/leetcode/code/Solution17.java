package me.coding.leetcode.code;

import me.coding.ds.list.ListNode;

class Solution17 {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null||head.next==null)return head;

        ListNode first = head;
        ListNode second = head.next;

        while(second!=null){
            int gcd = findGCD(first.val,second.val);
            ListNode newNode = new ListNode(gcd);
            newNode.next=second;
            first.next=newNode;
            first = second;
            second=second.next;
        }

        return head;
    }
}
