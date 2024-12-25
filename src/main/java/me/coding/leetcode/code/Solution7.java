package me.coding.leetcode.code;

import me.coding.ds.list.ListNode;

public class Solution7 {
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        else{
            if(head.next==null)return false;
            else{
                ListNode slow = head;
                ListNode fast = head.next;
                while(slow!=null&&fast!=null){
                    if(slow==fast)return true;
                    else{
                        if(slow.next!=null)slow = slow.next;
                        if(fast.next!=null){
                            fast=fast.next;
                        }else fast = null;
                        if(fast!=null && fast.next!=null){
                            fast=fast.next;
                        }else fast = null;
                    }
                }
                return false;
            }
        }
    }
//    public ListNode detectCycle(ListNode head) {
//        if(head==null||head.next==null)return null;
//        Set<ListNode> nodeSet = new HashSet<>();
//        ListNode ptr = head;
//        while (ptr!=null){
//            if(!nodeSet.add(ptr))return ptr;
//            ptr = ptr.next;
//        }
//        return null;
//    }
    public ListNode detectCycle(ListNode head) {
        if(head==null)return null;
        else{
            if(head.next==null)return null;
            else{
                ListNode slow = head;
                ListNode fast = head.next;
                while(slow!=null&&fast!=null){
                    if(slow==fast)return slow;
                    else{
                        if(slow.next!=null)slow = slow.next;
                        if(fast.next!=null){
                            fast=fast.next;
                        }else fast = null;
                        if(fast!=null && fast.next!=null){
                            fast=fast.next;
                        }else fast = null;
                    }
                }
                return null;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ptr = head;
        ptr.next=new ListNode(2);
        ptr = ptr.next;
        ptr.next=new ListNode(3);
        ptr = ptr.next;
        ptr.next=new ListNode(4);
        ListNode cycle = ptr;
        ptr = ptr.next;
        ptr.next=new ListNode(5);
        ptr = ptr.next;
        ptr.next=new ListNode(6);
        ptr = ptr.next;
        ptr.next=new ListNode(7);
        ptr = ptr.next;
        ptr.next=new ListNode(8);
        ptr = ptr.next;
        ptr.next = cycle;
        Solution7 s = new Solution7();
        boolean result = s.hasCycle(head);
        System.out.println(result);


    }
}
