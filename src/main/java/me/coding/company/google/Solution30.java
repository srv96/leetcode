package me.coding.company.google;

import me.coding.ds.set.MultiSet;

import java.util.*;

class Solution30 {
    public int[] findOriginalArray(int[] changed) {
        MultiSet<Integer> combined = new MultiSet<>();
        MultiSet<Integer> smaller = new MultiSet<>();
        MultiSet<Integer> bigger = new MultiSet<>();
        int len = changed.length;
        for (int i = 0; i < len; i++) {
            combined.add(changed[i]);
        }
        changed = Arrays.stream(changed).sorted().toArray();
        for (int i = 0; i < len; i++) {
            if (changed[i] == 0) {
                if (combined.count(changed[i]) >= 2) {
                    combined.remove(changed[i]);
                    combined.remove(changed[i] * 2);
                    smaller.add(changed[i]);
                    bigger.add(changed[i] * 2);
                }
            } else if (combined.contains(changed[i]) && combined.contains(changed[i] * 2)) {
                combined.remove(changed[i]);
                combined.remove(changed[i] * 2);
                smaller.add(changed[i]);
                bigger.add(changed[i] * 2);
            }
        }
        if ((smaller.size() == bigger.size()) && (smaller.size() * 2 == changed.length)) {
            List<Integer> result = new ArrayList<>();
            int size = smaller.size();
            for (Integer ele : smaller) {
                result.add(ele);
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[]{};
        }
    }
}
