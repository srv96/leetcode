package me.coding.company.visa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution12 {
    class Node {
        int num;
        int idx;
        boolean removed;

        public Node(int num, int idx, boolean removed) {
            this.num = num;
            this.idx = idx;
            this.removed = removed;
        }
    }

    public long findScore(int[] nums) {
        Map<Integer, Node> register = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.num == o2.num) return o1.idx - o2.idx;
                else return o1.num - o2.num;
            }
        });
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            Node n = new Node(nums[i], i, false);
            register.put(i, n);
            pq.add(n);
        }
        long score = 0;
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if (!n.removed) {
                score += n.num;
                if (register.containsKey(n.idx - 1)) register.get(n.idx - 1).removed = true;
                if (register.containsKey(n.idx + 1)) register.get(n.idx + 1).removed = true;
            }
        }
        return score;
    }
}