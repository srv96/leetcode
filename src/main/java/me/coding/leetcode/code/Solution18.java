package me.coding.leetcode.code;

import me.coding.ds.list.ListNode;

import java.util.Stack;

class Solution18 {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)return head;

        Stack<ListNode> stack = new Stack<>();

        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        ListNode root = null;
        while(!stack.isEmpty()){
            if(head==null){
                head = stack.pop();
                root=head;
            }else{
                head.next=stack.pop();
                head=head.next;
            }
        }
        head.next = null;
        return root;
    }
}
