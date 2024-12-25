package me.coding.leetcode.top150;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution58 {
    PriorityQueue<Integer> maxHeap, minHeap;

    public void dump(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (maxHeap.size() == 0) maxHeap.offer(arr[i]);
            else {
                if (arr[i] < maxHeap.peek()) {
                    maxHeap.offer(arr[i]);
                    while (maxHeap.size() - 1 > minHeap.size()) {
                        minHeap.offer(maxHeap.poll());
                    }
                } else {
                    minHeap.add(arr[i]);
                    while (minHeap.size() > maxHeap.size()) {
                        maxHeap.offer(minHeap.poll());
                    }
                }
            }
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Comparator.reverseOrder());

        dump(nums1);
        dump(nums2);

        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize == minHeapSize) return ((double) (maxHeap.peek() + minHeap.peek())) / 2;
        else return maxHeap.peek();
    }
}
