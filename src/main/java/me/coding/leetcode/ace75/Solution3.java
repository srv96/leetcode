package me.coding.leetcode.ace75;

import java.util.*;

class Solution3 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] visitMemo = new boolean[size];
        Queue<Integer> roomQueue = new LinkedList<>();
        visitMemo[0] = true;
        for(int i = 0 ; i < rooms.get(0).size() ; i++){
            roomQueue.offer(rooms.get(0).get(i));
        }
        while (!roomQueue.isEmpty()){
            int roomIdx = roomQueue.poll();
            for(int i = 0 ; i < rooms.get(roomIdx).size();i++){
                if(!visitMemo[roomIdx])roomQueue.offer(rooms.get(roomIdx).get(i));
            }
            visitMemo[roomIdx]=true;
        }
        for(int i = 0 ; i < size ; i++){
            if(!visitMemo[i])return false;
        }return true;
    }
}
