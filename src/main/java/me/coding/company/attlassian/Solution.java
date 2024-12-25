package me.coding.company.attlassian;

import java.util.*;

class Solution {
    public String rankTeams(String[] votes) {
        int nTeams = votes[0].length();
        Map<Character,Integer> rank = new HashMap<>();
        for(String vote : votes){
            for(int i = 0 ; i < nTeams ; i++){
                rank.put(vote.charAt(i),rank.getOrDefault(vote.charAt(i),0)+(nTeams-i));
            }
        }
        List<Character> keys = new ArrayList<>(rank.keySet());
        Collections.sort(keys, (o1, o2) -> {
            int result = rank.get(o1).compareTo(rank.get(o2));
            if (result != 0) return result;
            else return o2.compareTo(o1);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < nTeams ; i++){
            stringBuilder.append(keys.get(i));
        }
        return stringBuilder.reverse().toString();
    }
}
