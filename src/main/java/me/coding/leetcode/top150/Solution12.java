package me.coding.leetcode.top150;

import java.util.*;
import java.util.stream.Collectors;

class Solution12 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> groups = new HashMap<>();
        for(String str : strs){
            String sortedStr = str=="" ? "" : new String(str.chars().sorted().toArray(), 0, str.length());
            if(groups.get(sortedStr)==null){
                groups.put(sortedStr, new ArrayList<>(Arrays.asList(str)));
            }else{
                ArrayList<String> list = groups.get(sortedStr);
                list.add(str);
                groups.put(sortedStr,list);
            }
        }
        return groups.values().stream()
                .map(ArrayList::new)
                .collect(Collectors.toList());
    }
}
