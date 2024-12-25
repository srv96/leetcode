package me.coding.mostliked;

import java.util.*;

class Solution {
    public static Map<Character, ArrayList<String>> getKeypadMapping() {
        Map<Character, ArrayList<String>> keypadMapping = new HashMap<>();
        keypadMapping.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        keypadMapping.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        keypadMapping.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        keypadMapping.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        keypadMapping.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        keypadMapping.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        keypadMapping.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
        keypadMapping.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        return keypadMapping;
    }

    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))return new ArrayList<>();
        char[] digitsArr = digits.toCharArray();
        Map<Character, ArrayList<String>> keypadMapping = getKeypadMapping();
        List<String> result = new ArrayList<>();
        getCombination(digitsArr, keypadMapping,new StringBuilder(), result, 0, digitsArr.length);
        return result;
    }

    private void getCombination(char[] digitsArr, Map<Character, ArrayList<String>> keypadMapping,StringBuilder currStr, List<String> result, int idx, int size) {
        if (idx == size){
            result.add(currStr.toString());
            return;
        }
        else {
            List<String> digitChar = keypadMapping.get(digitsArr[idx]);
            for(String character : digitChar){
                currStr.append(character);
                getCombination(digitsArr,keypadMapping,currStr,result,idx+1,size);
                currStr.deleteCharAt(currStr.length()-1);
            }
        }
    }
}
