package me.coding.ds.collection;

import me.coding.ds.list.DoublyNode;

public class DoublyLinkedList {
    DoublyNode<Integer> head, tail, curr;
    int capacity;

    public DoublyLinkedList(int capacity) {
        head = null;
        tail = null;
        curr = null;
        this.capacity = capacity;
    }

    public void addElement(int element) {
        if (head == null && tail == null) {
            curr = new DoublyNode<>(element);
            head = curr;
            tail = curr;
        } else {
            curr.next = new DoublyNode<>(element);
            tail = curr.next;
            curr = curr.next;
        }
    }

    public void addNode(DoublyNode<Integer> node) {
        if (head == null && tail == null) {
            curr = node;
            head = curr;
            tail = curr;
        } else {
            curr.next = node;
            node.prev = curr;
            tail = curr.next;
            curr = curr.next;
        }
    }

    public void deleteNode(DoublyNode<Integer> node) {
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = tail.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = head.next;
        }
        if (head == null && tail == null) curr = null;
    }

}
