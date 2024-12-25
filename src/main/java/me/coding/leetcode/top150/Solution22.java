package me.coding.leetcode.top150;

import java.util.Stack;

class Solution22 {
    public int evalRPN(String[] tokens) {
        int size = tokens.length;
        if (size == 0) return 0;
        if (size == 1) return Integer.parseInt(tokens[0]);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            String token = tokens[i];
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer two = stack.pop();
                Integer one = stack.pop();
                if (token.equals("+")) stack.push(one + two);
                else if (token.equals("-")) stack.push(one - two);
                else if (token.equals("*")) stack.push(one * two);
                else if (token.equals("/")) stack.push(one / two);
            }
        }
        return stack.pop();
    }
}
