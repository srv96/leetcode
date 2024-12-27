package me.coding.company.google;

import me.coding.ds.list.ListNode;

import java.util.Stack;

class Solution42 {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> monoStack = new Stack<>();
        ListNode curr = head;
        while(curr!=null){
            if(monoStack.isEmpty() || monoStack.peek().val > curr.val){
                monoStack.push(curr);
            }else{
                while(!monoStack.isEmpty() && monoStack.peek().val < curr.val){
                    monoStack.pop();
                }
                monoStack.push(curr);
            }
            curr = curr.next;
        }
        curr = monoStack.pop();
        curr.next = null;
        while(!monoStack.isEmpty()){
            ListNode prev = monoStack.pop();
            prev.next = curr;
            curr = prev;
        }
        return curr;
    }
}