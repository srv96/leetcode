package me.coding.company.visa;

class Solution11 {
    public long minimumTime(int[] time, long totalTrips) {
        long currTime = 1, prevTime = 1;
        while (calculateTrips(time, currTime) < totalTrips) {
            prevTime = currTime;
            currTime *= 2;
        }
        long l = prevTime, r = currTime;
        long result = r;
        while (l <= r) {
            long mid = (l + r) / 2;
            long trip = calculateTrips(time, mid);
            if (trip >= totalTrips) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    private long calculateTrips(int[] time, long totalTime) {
        long len = time.length;
        long trips = 0;
        for (int i = 0; i < len; i++) {
            trips += totalTime / (long) time[i];
        }
        return trips;
    }
}