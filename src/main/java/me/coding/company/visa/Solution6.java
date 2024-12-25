package me.coding.company.visa;

import me.coding.ds.pair.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution6 {
    public void wallsAndGates(int[][] rooms) {
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<Pair<Integer, Integer>> distMap = new LinkedList<>();
        boolean[][] visitGrid = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(visitGrid[i], false);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) distMap.add(new Pair<>(i, j));
            }
        }
        while (!distMap.isEmpty()) {
            Pair<Integer, Integer> dist = distMap.poll();
            visitGrid[dist.key][dist.value]=true;
            if (isExist(rooms, visitGrid, dist.key - 1, dist.value, row, col)) {
                rooms[dist.key - 1][dist.value] = Math.min(rooms[dist.key - 1][dist.value], rooms[dist.key][dist.value] + 1);
                distMap.add(new Pair<>(dist.key - 1, dist.value));
            }
            if (isExist(rooms, visitGrid, dist.key, dist.value - 1, row, col)) {
                rooms[dist.key][dist.value - 1] = Math.min(rooms[dist.key][dist.value - 1], rooms[dist.key][dist.value] + 1);
                distMap.add(new Pair<>(dist.key, dist.value - 1));
            }
            if (isExist(rooms, visitGrid, dist.key, dist.value + 1, row, col)) {
                rooms[dist.key][dist.value + 1] = Math.min(rooms[dist.key][dist.value + 1], rooms[dist.key][dist.value] + 1);
                distMap.add(new Pair<>(dist.key, dist.value + 1));
            }
            if (isExist(rooms, visitGrid, dist.key + 1, dist.value, row, col)) {
                rooms[dist.key + 1][dist.value] = Math.min(rooms[dist.key + 1][dist.value], rooms[dist.key][dist.value] + 1);
                distMap.add(new Pair<>(dist.key + 1, dist.value));
            }
        }
        System.out.println("end");
    }

    private boolean isExist(int[][] rooms, boolean[][] visitGrid, int i, int j, int row, int col) {
        if (i >= 0 && i < row && j >= 0 && j < col)
            if (!visitGrid[i][j] && rooms[i][j] != -1) return true;
        return false;
    }
}