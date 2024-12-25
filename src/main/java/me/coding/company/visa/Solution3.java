package me.coding.company.visa;

import java.util.TreeSet;

class Solution3 {
    public int maxEvents(int[][] events) {
        TreeSet<int[]> eventsQueue = new TreeSet<>((o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            else if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[2] - o2[2];
        });
        int size = events.length;
        int maxSize = Integer.MIN_VALUE;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            eventsQueue.add(new int[]{events[i][0], events[i][1], i});
            maxSize = Math.max(maxSize, events[i][1]);
            minSize = Math.min(minSize, events[i][0]);
        }
        TreeSet<Integer> eventList = new TreeSet<>();
        for (int i = minSize; i <= maxSize; i++) {
            eventList.add(i);
        }
        int count = 0;
        while (!eventsQueue.isEmpty()&&!eventList.isEmpty()) {
            int[] event = eventsQueue.pollFirst();
            int start = Math.max(event[0], eventList.first());
            int end = Math.min(event[1], eventList.last());
            for (int i = start; i <= end; i++) {
                if (eventList.contains(i)) {
                    eventList.remove(i);
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
