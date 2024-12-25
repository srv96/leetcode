package me.coding.leetcode.top150;


import me.coding.ds.list.Node;

class Solution35 {
    public Node copyRandomList(Node head) {
        Node pivot = head;

        while(pivot!=null){
            Node tempNode = new Node(pivot.val);
            tempNode.next=pivot.next;
            pivot.next=tempNode;
            pivot = pivot.next.next;
        }

        pivot = head;
        while (pivot!=null){
            pivot.next.random = pivot.random!=null ? pivot.random.next : null;
            pivot = pivot.next.next;
        }

        Node newHead = null,newPivot = null;
        pivot = head;

        while(pivot!=null){
            if(newHead==null){
                newHead = pivot.next;
                newPivot=newHead;
                pivot.next = pivot.next.next;
                pivot = pivot.next;
                continue;
            }
            newPivot.next=pivot.next;
            pivot.next = pivot.next.next;
            pivot = pivot.next;
            newPivot = newPivot.next;
        }
        return newHead;
    }
}