package me.coding.leetcode.code;

import java.util.*;

class Solution30 {
    public List<List<String>> findDuplicate(String[] paths) {
        int size = paths.length;
        Map<String,List<String>> data = new HashMap<>();
        for(int  i = 0 ; i < size ; i ++){
            String[] parts = paths[i].split(" ");
            int count = parts.length;
            String path = parts[0];
            for(int j = 1 ; j < count ; j++){
                String[] filePart = parts[j].split("\\(");
                String fileName = filePart[0];
                String content = filePart[1].replace(")","");
                if(data.get(content)==null){
                    data.put(content,new ArrayList<>());
                }
                List<String> lst = data.get(content);
                lst.add(path + "/" + fileName);
                data.put(content,lst);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String content : data.keySet()){
            if(data.get(content).size()>1){
                result.add(data.get(content));
            }
        }
        return result;
    }
}
