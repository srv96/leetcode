package me.coding.leetcode.top150;

class Solution9 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        if (size == 1 && gas[0] == cost[0]) return 0;
        int[] diff = new int[size];
        int diffSum = 0;
        for (int i = 0; i < size; i++) {
            diff[i] = gas[i] - cost[i];
            diffSum += diff[i];
        }
        if (diffSum < 0) {
            return -1;
        } else {
            boolean flag = true;
            for (int i = 0; i < size; i++) {
                if (diff[i] > 0) {
                    flag = true;
                    int fuel = 0;
                    for (int j = i; j < i + size; j++) {
                        fuel += gas[j % size];
                        fuel -= cost[j % size];
                        if (fuel < 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) return i;
                }
            }
            return -1;
        }
    }
}
