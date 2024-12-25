package me.coding.company.google;

import java.util.HashMap;
import java.util.Map;

class Logger {
    Map<String, Integer> timekeeper;

    public Logger() {
        timekeeper = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!timekeeper.containsKey(message)) {
            timekeeper.put(message, timestamp + 10);
            return true;
        } else {
            if (timekeeper.get(message) <= timestamp) {
                timekeeper.put(message, timestamp + 10);
                return true;
            } else {
                return false;
            }
        }
    }
}
