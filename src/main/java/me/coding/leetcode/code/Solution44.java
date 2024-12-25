package me.coding.leetcode.code;

import me.coding.ds.list.ListNode;

class Solution44 {
    public ListNode oddEvenList(ListNode head) {
        ListNode even = null, odd = null, evenHead = null, oddHead = null;
        int count  = 1;
        while (head != null) {
            if (count % 2 == 0) {
                if (even == null) {
                    even = head;
                    evenHead = even;
                    head = head.next;
                    even.next = null;
                    count++;
                } else {
                    even.next = head;
                    even = even.next;
                    head = head.next;
                    even.next=null;
                    count++;
                }
            } else {
                if (odd == null) {
                    odd = head;
                    oddHead = head;
                    head = head.next;
                    odd.next=null;
                    count++;
                } else {
                    odd.next = head;
                    odd = odd.next;
                    head = head.next;
                    odd.next=null;
                    count++;
                }
            }

        }
        if(odd!=null){
            odd.next=evenHead;
            return oddHead;
        }else return evenHead;
    }
}
