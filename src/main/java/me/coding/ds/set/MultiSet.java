package me.coding.ds.set;

import java.util.*;

public class MultiSet<T> implements Iterable<T> {
    private Map<T, Integer> eleCount;
    private int size;

    public MultiSet() {
        eleCount = new HashMap<>();
    }

    public void add(T element) {
        eleCount.put(element, eleCount.getOrDefault(element, 0) + 1);
        size++;
    }

    public void remove(T element) {
        if (eleCount.containsKey(element)) {
            if (eleCount.get(element) == 1) {
                eleCount.remove(element);
            } else {
                eleCount.put(element, eleCount.get(element) - 1);
            }
            size--;
        }
    }

    public boolean contains(T element) {
        return eleCount.containsKey(element);
    }

    public int size() {
        return size;
    }

    public int count(T element) {
        if (eleCount.containsKey(element)) return eleCount.get(element);
        else return 0;
    }

    @Override
    public Iterator<T> iterator() {
        // Create a new list to hold all elements, including duplicates
        List<T> allElements = new ArrayList<>();
        for (Map.Entry<T, Integer> entry : eleCount.entrySet()) {
            T element = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                allElements.add(element);
            }
        }
        return allElements.iterator(); // Return an iterator over the list
    }
}
