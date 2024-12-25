package me.coding.sandbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Obj{
    int value;

    public Obj(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
public class PriorityQueueTest {
    public static void main(String[] args) {
        List<Obj> objList = new ArrayList<>();
        objList.add(new Obj(7));
        objList.add(new Obj(5));
        objList.add(new Obj(8));
        objList.add(new Obj(2));
        objList.add(new Obj(4));
        objList.add(new Obj(6));
        objList.add(new Obj(9));
        objList.add(new Obj(3));
        PriorityQueue<Obj> pq = new PriorityQueue<>(Comparator.comparing(obj -> obj.value));
        pq.addAll(objList);
        pq.remove(objList.get(6));
        objList.get(6).value=1;
        pq.add(objList.get(6));
        while (!pq.isEmpty()) System.out.print(pq.poll().value+" ");
    }
}
