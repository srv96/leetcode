package me.coding.leetcode.top150;

import me.coding.ds.list.ListNode;

class Solution36 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode tempHead = new ListNode(Integer.MIN_VALUE);
        tempHead.next = head;
        ListNode pivot = tempHead;
        while(pivot!=null){
            if(pivot.next!=null&&pivot.next.next!=null&&pivot.next.val==pivot.next.next.val)removeVal(pivot);
            else pivot=pivot.next;
        }
        return tempHead.next;
    }

    private void removeVal(ListNode ptr) {
        if(ptr==null||ptr.next==null||ptr.next.next==null)return;
        ListNode pivot = ptr.next;
        while(pivot!=null &&pivot.val==ptr.next.val)pivot=pivot.next;
        ptr.next=pivot;
    }
}


//    public ListNode deleteDuplicates(ListNode head) {
//        if(head==null || head.next==null)return head;
//        ListNode pivot = head;
//
//        while(pivot!=null){
//            while(pivot.next!=null&&pivot.val==pivot.next.val){
//                pivot.next=pivot.next.next;
//            }
//            pivot = pivot!=null?pivot.next:null;
//        }
//
//        return head;
//    }
