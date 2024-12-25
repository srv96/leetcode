package me.coding.leetcode.ace75;

import java.util.Stack;

class Solution5 {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int size = s.length();
        for(int i = 0 ; i < size ; i++){
            if(s.charAt(i)!='*')stack.push(s.charAt(i));
            else{
                if(!stack.isEmpty())stack.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
