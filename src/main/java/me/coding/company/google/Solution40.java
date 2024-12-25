package me.coding.company.google;

class Solution40 {
    public double averageWaitingTime(int[][] customers) {
        long time = 0;
        double wait = 0;
        int len = customers.length;
        for (int i = 0; i < len; i++) {
            if (time < customers[i][0]) {
                time = customers[i][0];
            }
            time += customers[i][1];
            wait += (time - customers[i][0]);
        }
        return wait / (double) len;
    }
}
