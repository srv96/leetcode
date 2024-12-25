package me.coding.company.microsoft;

import java.util.Stack;

class Solution25 {
    Stack<Character> monoStack;

    public String removeKdigits(String num, int k) {
        monoStack = new Stack<>();
        int remainingK = addDigit(num, k);
        for (int i = 0; i < remainingK; i++) {
            if (!monoStack.isEmpty()) monoStack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!monoStack.isEmpty()) {
            sb.append(monoStack.pop());
        }
        sb = sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() > 0 ? sb.toString() : "0";
    }

    private int addDigit(String num, int k) {
        int size = num.length();
        for (int i = 0; i < size; i++) {
            while (!monoStack.isEmpty() && monoStack.peek() > num.charAt(i)) {
                if (k > 0) {
                    monoStack.pop();
                    k--;
                } else {
                    break;
                }
            }
            monoStack.push(num.charAt(i));
        }
        return k;
    }
}