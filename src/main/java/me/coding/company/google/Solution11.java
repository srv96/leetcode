package me.coding.company.google;

import java.util.PriorityQueue;
import java.util.TreeSet;

class Solution11 {
    class MeetingRoom {
        public int roomNumber;
        public int startTime;
        public int endTime;
        public int usedCount;

        public MeetingRoom(int roomNumber, int startTime, int endTime) {
            this.roomNumber = roomNumber;
            this.startTime = startTime;
            this.endTime = endTime;
            this.usedCount = 0;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        TreeSet<MeetingRoom> meetingRooms = new TreeSet<>((o1, o2) -> {
            if (o1.endTime == o2.endTime) return o1.roomNumber - o2.roomNumber;
            else return o1.endTime - o2.endTime;
        });
        PriorityQueue<int[]> meetingSequence = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });

        for (int i = 0; i < n; i++) {
            meetingRooms.add(new MeetingRoom(i, 0, 0));
        }
        int size = meetings.length;
        for (int i = 0; i < size; i++) {
            meetingSequence.add(meetings[i]);
        }
        while (!meetingSequence.isEmpty()) {
            MeetingRoom meetingRoom = meetingRooms.pollFirst();
            int[] meeting = meetingSequence.poll();
            if (meeting[0] >= meetingRoom.endTime) {
                meetingRoom.startTime = meeting[0];
                meetingRoom.endTime = meeting[1];
            } else {
                meetingRoom.startTime = meetingRoom.endTime;
                meetingRoom.endTime = meetingRoom.endTime + (meeting[1] - meeting[0]);
            }
            meetingRoom.usedCount++;
            meetingRooms.add(meetingRoom);
        }
        int maxMeeting = Integer.MIN_VALUE;
        int maxRoomNumber = -1;
        while (!meetingRooms.isEmpty()) {
            MeetingRoom meetingRoom = meetingRooms.pollFirst();
            if (maxMeeting <= meetingRoom.usedCount) {
                if(maxMeeting == meetingRoom.usedCount){
                    if(meetingRoom.roomNumber < maxRoomNumber){
                        maxRoomNumber = meetingRoom.roomNumber;
                        continue;
                    }
                }
                maxMeeting = Math.max(maxMeeting, meetingRoom.usedCount);
                maxRoomNumber = meetingRoom.roomNumber;
            }
        }
        return maxRoomNumber;
    }
}
