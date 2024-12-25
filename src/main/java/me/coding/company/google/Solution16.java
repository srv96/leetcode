package me.coding.company.google;

import me.coding.ds.list.ListNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution16 {
    public ListNode swapPairs(ListNode head) {
        Queue<ListNode> a = new LinkedList<>(), b = new LinkedList<>();
        ListNode curr = head;
        while(curr!=null){
            a.add(curr);
            curr=curr.next;
            if(curr!=null)b.add(curr);
            if(curr!=null)curr=curr.next;
        }
        ListNode result = null;
        while(!a.isEmpty()&&!b.isEmpty()){
            if(result==null){
                result = b.poll();
                curr = result;
                curr.next = a.poll();
                curr = curr.next;
                continue;
            }
            curr.next=b.poll();
            curr = curr.next;
            curr.next=a.poll();
            curr=curr.next;
        }
        if(a.isEmpty()){
            while (!b.isEmpty()){
                if(curr==null){
                    result = b.poll();
                    curr = head;
                    continue;
                }
                curr.next=b.poll();
                curr = curr.next;
            }
        }
        if(b.isEmpty()){
            while (!a.isEmpty()){
                if(curr==null){
                    result = a.poll();
                    curr = head;
                    continue;
                }
                curr.next=a.poll();
                curr = curr.next;
            }
        }
        if(curr!=null)curr.next=null;
        return result;
    }
}