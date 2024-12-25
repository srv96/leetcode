package me.coding.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution6 {
    class MeetingRoom {
        List<int[]> meeting;

        public MeetingRoom(List<int[]> meeting) {
            this.meeting = meeting;
        }
    }
    boolean isSuitable(MeetingRoom meetingRoom , int[] interval){
        for(int[] meeting : meetingRoom.meeting){
            if(((meeting[0] <interval[0])&&(meeting[1]>interval[0]))||((meeting[0] <interval[1])&&(meeting[1]>interval[1])))return false;
            if(((interval[0] <meeting[0])&&(interval[1]>meeting[0]))||((interval[0] <meeting[1])&&(interval[1]>meeting[1])))return false;
            if(meeting[0]==interval[0]&&meeting[1]==interval[1])return false;
        }
        return true;
    }
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<MeetingRoom> office = new ArrayList<>();
        office.add(new MeetingRoom(new ArrayList<>(List.of(intervals[0]))));
        int size = intervals.length;
        for (int i = 1; i < size; i++) {
            boolean needRoom = true;
            for(MeetingRoom meetingRoom : office){
                if(isSuitable(meetingRoom,intervals[i])){
                    meetingRoom.meeting.add(intervals[i]);
                    needRoom=false;
                    break;
                }
            }
            if(needRoom)office.add(new MeetingRoom(new ArrayList<>(List.of(intervals[i]))));

        }
        return office.size();
    }
}
