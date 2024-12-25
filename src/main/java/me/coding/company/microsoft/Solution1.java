package me.coding.company.microsoft;

import java.util.*;

class Solution1 {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");
        List<Map.Entry<Integer,String>> entryList = new ArrayList<>(romanMap.entrySet());
       entryList.sort((o1, o2) -> o2.getKey()-o1.getKey());
        romanMap.clear();
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<Integer,String> entry : entryList){
            int freq = num/entry.getKey();
            for(int i = 0 ; i < freq ; i++){
                stringBuilder.append(entry.getValue());
            }
            num = num %entry.getKey();
        }
        return stringBuilder.toString();
    }
}