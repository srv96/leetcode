package me.coding.leetcode.top150;

import me.coding.ds.list.ListNode;

class Solution18 {
    public int length(ListNode head){
        ListNode node = head;
        int count = 0;
        while(node!=null){
            count++;
            node = node.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null ||head.next==null)return head;
        int length = length(head);
        int rotateLength = k%length;
        if(rotateLength == 0)return head;
        ListNode pivot = head;
        for(int i = 0 ; i < length-rotateLength-1 ; i++){
            pivot = pivot.next;
        }
        ListNode newHead = pivot.next;
        pivot.next=null;
        pivot = newHead;
        while(pivot.next !=null){
            pivot = pivot.next;
        }
        pivot.next=head;
        return newHead;
    }
}
