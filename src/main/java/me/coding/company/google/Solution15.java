package me.coding.company.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

class Solution15 {
    class MeetingRoom {
        public int roomNumber;
        public long startTime;
        public long endTime;
        public int usedCount;

        public MeetingRoom(int roomNumber, long startTime, long endTime) {
            this.roomNumber = roomNumber;
            this.startTime = startTime;
            this.endTime = endTime;
            this.usedCount = 0;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        TreeSet<MeetingRoom> meetingRoomsFree = new TreeSet<>(Comparator.comparingInt(o -> o.roomNumber));
        TreeSet<MeetingRoom> meetingRoomsUsed = new TreeSet<>((o1, o2) -> {
            if (o1.endTime == o2.endTime) return o1.roomNumber - o2.roomNumber;
            return o1.endTime - o2.endTime > 0 ?1:-1;
        });
        PriorityQueue<int[]> meetingsSequence = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
        for (int i = 0; i < n; i++) {
            meetingRoomsFree.add(new MeetingRoom(i, 0, 0));
        }
        meetingsSequence.addAll(Arrays.asList(meetings));
        while (!meetingsSequence.isEmpty()) {
            int[] temp = meetingsSequence.poll();
            long [] meeting = new long[]{temp[0],temp[1]};
            boolean allotted = false;
            while (!allotted) {
                while (!meetingRoomsUsed.isEmpty()) {
                    MeetingRoom room = meetingRoomsUsed.first();
                    if (room.endTime <= meeting[0]) meetingRoomsFree.add(meetingRoomsUsed.pollFirst());
                    else break;
                }
                if ((!meetingRoomsFree.isEmpty())) {
                    MeetingRoom freeRoom = meetingRoomsFree.pollFirst();
                    freeRoom.startTime = meeting[0];
                    freeRoom.endTime = meeting[1];
                    freeRoom.usedCount++;
                    meetingRoomsUsed.add(freeRoom);
                    allotted = true;
                }
                if (!allotted) {
                    MeetingRoom used = meetingRoomsUsed.first();
                    long start = meeting[0];
                    meeting[0] = used.endTime;
                    meeting[1] = meeting[0] + (meeting[1] - start);
                }
            }
        }
        int count = Integer.MIN_VALUE;
        int roomNumber = Integer.MAX_VALUE;
        while (!meetingRoomsUsed.isEmpty()) {
            if (count <= meetingRoomsUsed.first().usedCount) {
                if (meetingRoomsUsed.first().usedCount == count) {
                    roomNumber = Math.min(roomNumber, meetingRoomsUsed.pollFirst().roomNumber);
                } else {
                    count = meetingRoomsUsed.first().usedCount;
                    roomNumber = meetingRoomsUsed.pollFirst().roomNumber;
                }
            } else {
                meetingRoomsUsed.pollFirst();
            }
        }
        while (!meetingRoomsFree.isEmpty()) {
            if (count <= meetingRoomsFree.first().usedCount) {
                if (meetingRoomsFree.first().usedCount == count) {
                    roomNumber = Math.min(roomNumber, meetingRoomsFree.pollFirst().roomNumber);
                } else {
                    count = meetingRoomsFree.first().usedCount;
                    roomNumber = meetingRoomsFree.pollFirst().roomNumber;
                }
            } else {
                meetingRoomsFree.pollFirst();
            }
        }
        return roomNumber;
    }
}
