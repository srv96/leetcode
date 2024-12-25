package me.coding.company.microsoft;

import java.util.*;

class Solution4 {
    public String largestPalindromic(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = num.length();
        for (int i = 0; i < size; i++) {
            map.put(num.charAt(i) - '0', map.getOrDefault(num.charAt(i) - '0', 0) + 1);
        }
        List<Integer> digits = new ArrayList<>();
        Integer maxOdd = -1;
        for (Integer key : map.keySet()) {
            int dSize = map.get(key);
            if (dSize % 2 == 0) {
                while (dSize != 0) {
                    digits.add(key);
                    dSize -= 2;
                }
            } else {
                while (dSize > 1) {
                    digits.add(key);
                    dSize -= 2;
                }
                maxOdd = Integer.max(maxOdd, key);
            }
        }
        Collections.sort(digits);
        size = digits.size();
        StringBuilder res = new StringBuilder(), revRes = new StringBuilder();
        for (int i = 0; i < size; i++) {
            res.append(digits.get(i));
        }
        revRes = res.reverse();
        if(maxOdd!=-1){
            revRes.append(maxOdd).append(res);
        }else{
            revRes.append(res);
        }
        while(revRes.charAt(0)=='0'&&revRes.length()>=3){
            revRes.deleteCharAt(0);
            revRes.deleteCharAt(revRes.length()-1);
        }
        String result = revRes.toString();
        if(result.equals("00"))return "0";
        else return result;
    }
}
