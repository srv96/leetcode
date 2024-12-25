package me.coding.hackerrank;

import java.util.*;

public class Solution4 {
    public static int getNextNum(String str , int idx){
        int num = 0;
        int size = str.length();
        for(int i = idx+1 ; i<size&&(int)str.charAt(i)-48 <= 9 ;i++){
            num*=10;
            num+=((int)str.charAt(i)-48);
        }
        return num;
    }
    public static String betterCompression(String str){
        int size = str.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < size ; i++){
            if((int)str.charAt(i)>=97&&(int)str.charAt(i)<=122){
                if(map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i),map.get(str.charAt(i))+getNextNum(str,i));
                }
                else map.put(str.charAt(i),getNextNum(str,i));
            }
        }
        List<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder result = new StringBuilder();
        for(Character ch : keys){
            result.append(ch);
            result.append(map.get(ch));
        }
        return result.toString();
    }
}
