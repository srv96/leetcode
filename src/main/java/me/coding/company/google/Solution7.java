package me.coding.company.google;

import java.util.*;

class Solution7 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            if (nums.get(entry[0]).get(entry[1]) > 0) {
                result.add(nums.get(entry[0]).get(entry[1]));
                List<Integer> row = nums.get(entry[0]);
                row.set(entry[1], -1);
                if (isAvailable(nums, entry[0] + 1, entry[1])) queue.offer(new int[]{entry[0] + 1, entry[1]});
                if (isAvailable(nums, entry[0], entry[1] + 1)) queue.offer(new int[]{entry[0], entry[1] + 1});
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    private boolean isAvailable(List<List<Integer>> nums, int i, int j) {
        if (i < nums.size() && j < nums.get(i).size()) return true;
        return false;
    }
}
