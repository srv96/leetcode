package me.coding.company.amazon;

import java.util.*;

class Solution2 {
    public String reorganizeString(String s) {
        if(s.equals(""))return s;
        Map<Character, Integer> charFreq = new LinkedHashMap<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (!charFreq.containsKey(s.charAt(i))) charFreq.put(s.charAt(i), 1);
            else charFreq.put(s.charAt(i), charFreq.get(s.charAt(i)) + 1);
        }
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(charFreq.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        charFreq.clear();
        Map.Entry<Character, Integer> maxEntry = entryList.get(0);
        StringBuilder stringBuilder = new StringBuilder(size);
        for(int i = 0 ; i < size ; i++)stringBuilder.append(' ');
        if ((float) maxEntry.getValue() - ((float) size / 2) >= 1) return "";
        else {
            int idx = 0;
            for (Map.Entry<Character, Integer> entry : entryList) {
                int val = entry.getValue();
                for (int i = 0; i < val; i++) {
                    if (idx >= size) idx = 1;
                    stringBuilder.setCharAt(idx, entry.getKey());
                    idx += 2;
                }
            }
        }
        return stringBuilder.toString();
    }
}