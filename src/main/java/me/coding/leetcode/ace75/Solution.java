package me.coding.leetcode.ace75;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        int size = s.length();
        StringBuilder str = new StringBuilder();
        int number = 0;
        String charGrp = "";
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < size ; i++){
            if(s.charAt(i)=='['){
                while(!stack.isEmpty()){
                    str.append(stack.pop());
                }
                number =  Integer.parseInt(str.reverse().toString());
                str.setLength(0);
            }
            else if(s.charAt(i)==']'){
                while(!stack.isEmpty()){
                    str.append(stack.pop());
                }
                charGrp = str.reverse().toString();
                for(int j = 0 ; j < number ; j++){
                    result.append(charGrp);
                }
                str.setLength(0);
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        return result.toString();
    }
}
