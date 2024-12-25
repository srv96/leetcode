package me.coding.company.google;

import me.coding.ds.pair.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class HitCounter {
    PriorityQueue<Integer> timeKeeper;

    public HitCounter() {
        timeKeeper = new PriorityQueue<>();
    }

    public void hit(int timestamp) {
        timeKeeper.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!timeKeeper.isEmpty()&&timeKeeper.peek() <= timestamp - 300) timeKeeper.poll();
        List<Integer> hitList = new ArrayList<>();
        while (!timeKeeper.isEmpty() && timeKeeper.peek() <= timestamp) hitList.add(timeKeeper.poll());
        timeKeeper.addAll(hitList);
        return hitList.size();
    }
}
