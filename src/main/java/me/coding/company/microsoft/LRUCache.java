package me.coding.company.microsoft;

import me.coding.ds.list.DoublyNode;
import me.coding.ds.pair.Pair;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public int capacity;
    public Map<Integer, DoublyNode<Pair<Integer, Integer>>> memo;
    public DoublyNode<Pair<Integer, Integer>> head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoublyNode<>(new Pair<>(Integer.MIN_VALUE, Integer.MIN_VALUE));
        tail = new DoublyNode<>(new Pair<>(Integer.MAX_VALUE, Integer.MAX_VALUE));
        this.memo = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!memo.containsKey(key)) return -1;
        else {
            DoublyNode node = memo.get(key);
            DoublyNode prev = node.prev;
            DoublyNode next = node.next;
            prev.next = next;
            next.prev = prev;
            DoublyNode headNext = head.next;
            node.next = headNext;
            node.prev = head;
            head.next = node;
            headNext.prev = node;
            return memo.get(key).val.value;
        }
    }

    public void put(int key, int value) {
        if(memo.containsKey(key)){
            DoublyNode node = memo.get(key);
            DoublyNode prev = node.prev;
            DoublyNode next = node.next;
            prev.next = next;
            next.prev = prev;
            memo.remove(key);
        }
        while (memo.size() >= capacity) {
            DoublyNode<Pair<Integer, Integer>> lru = tail.prev;
            int tmpKey = lru.val.getKey();
            DoublyNode lruPrev = lru.prev;
            lruPrev.next = tail;
            tail.prev = lruPrev;
            memo.remove(tmpKey);
        }
        DoublyNode<Pair<Integer, Integer>> node = new DoublyNode<>(new Pair<>(key, value));
        DoublyNode headNext = head.next;
        node.prev = head;
        node.next = headNext;
        head.next = node;
        headNext.prev = node;
        memo.put(key, node);
    }
}
