package me.coding.leetcode.top150;

import me.coding.ds.list.ListNode;

class Solution19 {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)return head;

        ListNode small=null,big=null;
        ListNode pivot = head,smallPivot = null,bigPivot=null;
        while(pivot!=null){
            if(pivot.val < x){
                if(small==null){
                    small = pivot;
                    smallPivot=pivot;
                }else{
                    smallPivot.next=pivot;
                    smallPivot = smallPivot.next;

                }
            }else{
                if(big==null){
                    big = pivot;
                    bigPivot=pivot;
                }else{
                    bigPivot.next=pivot;
                    bigPivot = bigPivot.next;
                }
            }
            pivot = pivot.next;
        }
        if(small!=null&&smallPivot==null){
            smallPivot=small;
            while(smallPivot.next!=null)smallPivot = smallPivot.next;
        } else if (small==null) return big;
        smallPivot.next=big;
        if(bigPivot!=null)bigPivot.next=null;
        return small;
    }
}
