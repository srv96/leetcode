package me.coding.company.microsoft;

import me.coding.ds.pair.Pair;

import java.util.Stack;

class Solution11 {
    public String removeDuplicates(String s, int k) {
        char[] charSeq = s.toCharArray();
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(charSeq[0], 1));
        int size = charSeq.length;
        for (int i = 1; i < size; i++) {
            if (!stack.isEmpty() && stack.peek().key == charSeq[i])stack.peek().value++;
            else stack.push(new Pair<>(charSeq[i],1));
            if(!stack.isEmpty()&&stack.peek().value==k)stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair<Character,Integer> pair = stack.pop();
            for(int i = 0 ; i < pair.value ; i++){
                sb.append(pair.key);
            }
        }
        return sb.reverse().toString();
    }
}
