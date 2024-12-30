package me.coding.sandbox;

import java.util.HashMap;
import java.util.Map;

public class CollectionSndBox {
    public static void main(String[] args) {
        Integer key1 = Integer.valueOf(10);
        Integer key2 = Integer.valueOf(10);

        Map<Integer, String> identityMap = new HashMap<>();

        identityMap.put(key1, "Value for key1");
        identityMap.put(key2, "Value for key2");

        System.out.println("IdentityHashMap size: " + identityMap.size()); // Output: 2
        System.out.println("Value for key1: " + identityMap.get(key1)); // Output: Value for key1
        System.out.println("Value for key2: " + identityMap.get(key2)); // Output: Value for key2
    }
}