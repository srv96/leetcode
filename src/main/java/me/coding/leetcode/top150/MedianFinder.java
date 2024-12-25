package me.coding.leetcode.top150;

import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> maxHeap, minHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Comparator.reverseOrder());
    }
    public void addNum(int num) {
        if (maxHeap.size() == 0) maxHeap.offer(num);
        else {
            if (num < maxHeap.peek()) {
                maxHeap.offer(num);
                while (maxHeap.size() - 1 > minHeap.size()) {
                    minHeap.offer(maxHeap.poll());
                }
            } else {
                minHeap.add(num);
                while (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
            }
        }
    }

    public double findMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize == minHeapSize) return ((double) (maxHeap.peek() + minHeap.peek())) / 2;
        else return maxHeap.peek();
    }
}
