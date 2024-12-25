package me.coding.company.walmart;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution16 {
    public int calculate(String s) {
        s = s.trim();
        List<String> tokens = multiTokenizer(s);
        Stack<String> opStack = new Stack<>();
        List<String> result = new ArrayList<>();
        int size = tokens.size();
        for (int i = 0; i < size; i++) {
            if (isOperator(tokens.get(i).trim())) {
                if (opStack.isEmpty()) {
                    opStack.push(tokens.get(i).trim());
                    continue;
                }
                while (!opStack.isEmpty()) {
                    if (priority(opStack.peek()) < priority(tokens.get(i).trim())) {
                        opStack.push(tokens.get(i).trim());
                        break;
                    } else {
                        result.add(opStack.pop());
                    }
                    if (opStack.isEmpty()) {
                        opStack.push(tokens.get(i).trim());
                        break;
                    }
                }
            } else {
                result.add(tokens.get(i).trim());
            }
        }
        while (!opStack.isEmpty()) {
            result.add(opStack.pop());
        }
        for (int i = 0; i < result.size(); i++) {
            if (!isOperator(result.get(i))) {
                opStack.push(result.get(i));
            } else {
                String right = opStack.pop();
                String left = opStack.pop();
                opStack.push(eval(left, right, result.get(i)));
            }
        }

        return Integer.parseInt(opStack.pop());
    }

    private String eval(String l, String r, String op) {
        int right = Integer.parseInt(r);
        int left = Integer.parseInt(l);
        if (op.equals("+")) return String.valueOf(left + right);
        if (op.equals("-")) return String.valueOf(left - right);
        if (op.equals("*")) return String.valueOf(left * right);
        if (op.equals("/")) return String.valueOf(left / right);
        return "";
    }

    private List<String> multiTokenizer(String s) {
        String delimiters = "[+*-/\\s]+";
        Pattern pattern = Pattern.compile(delimiters + "|[^" + delimiters + "]+");
        Matcher matcher = pattern.matcher(s);
        List<String> tokens = new ArrayList<>();
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }

    private boolean isOperator(String token) {
        return
                token.equals("+") ||
                        token.equals("-") ||
                        token.equals("*") ||
                        token.equals("/");
    }

    private int priority(String operator) {
        if (operator.equals("+")) return 1;
        else if (operator.equals("-")) return 1;
        else if (operator.equals("*")) return 2;
        else if (operator.equals("/")) return 2;
        else return -1;
    }
}