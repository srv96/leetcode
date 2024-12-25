package me.coding.leetcode.code;

import java.util.*;

class Solution36 {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer,Integer> map = new Hashtable<>();
        int size = nums.length;
        for(int i = 0 ; i < size ; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!map.isEmpty()){
            List<Integer> row = new ArrayList<>();
            for(Integer key : map.keySet()){
                if(map.get(key)!=0){
                    row.add(key);
                    map.put(key,map.get(key)-1);
                }
            }
            result.add(row);
        }
        return result;
    }
}
