package me.coding.ds.list;

import java.nio.DoubleBuffer;

public class DoublyNode<T> {
    public T val;
    public  DoublyNode prev;
    public  DoublyNode next;

    public DoublyNode(T val){
        this.val=val;
        this.prev = null;
        this.next = null;
    }

    public DoublyNode(T val, DoublyNode prev, DoublyNode next) {
        this.val=val;
        this.prev = prev;
        this.next = next;
    }
}
