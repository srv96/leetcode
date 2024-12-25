package me.coding.company.adobe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int size = nums.length;
        for(int i = 0 ; i < size ; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int maxFreq = Integer.MIN_VALUE;
        for(Integer key : map.keySet()){
            maxFreq = Math.max(maxFreq,map.get(key));
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < maxFreq ; i++){
            result.add(new ArrayList<>());
        }
        for(Integer key : map.keySet()){
            for(int i = 0 ; i < map.get(key) ; i++){
                result.get(i).add(key);
            }
        }
        return result;
    }
}