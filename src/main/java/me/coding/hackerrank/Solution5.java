package me.coding.hackerrank;

import java.util.*;

public class Solution5 {
    public static List<String> compute(List<List<String>> sources) {
        Set<String> set = new LinkedHashSet<>();
        Map<String,String> finalList = new HashMap<>();

        int rowsSize = sources.size();
        for(int i = 0 ; i < rowsSize ; i++){
            List<String> source = sources.get(i);
            int parameterSize = source.size();
            for(int j = 0 ; j < parameterSize ; j++){
                String[] keyVal = source.get(j).split(":");
                String key = keyVal[0];
                String val = keyVal[1];
                set.add(key);
                finalList.put(key,val);
            }
        }
        List<String> result = new ArrayList<>();
        for(String key : set){
            result.add(finalList.get(key));
        }
        return result;
    }
}
