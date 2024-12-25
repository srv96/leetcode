package me.coding.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

class Solution37 {
    Map<Character, BiFunction<Integer, Integer, Integer>> operations = Map.of(
            '+', (x, y) -> x + y,
            '-', (x, y) -> x - y,
            '*', (x, y) -> x * y
    );

    List<Integer>[][] memo;

    public List<Integer> diffWaysToCompute(String expression) {
        memo = new List[expression.length()][expression.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], new ArrayList<>());
        }
        return diffWaysToCompute(expression, 0, expression.length() - 1);
    }

    private List<Integer> diffWaysToCompute(String expression, int l, int r) {
        if (memo[l][r].isEmpty()) {
            List<Integer> result = new ArrayList<>();

            for (int i = l; i <= r; i++) {
                if (operations.containsKey(expression.charAt(i))) {
                    List<Integer> calc1 = diffWaysToCompute(expression, l, i - 1);
                    List<Integer> calc2 = diffWaysToCompute(expression, i + 1, r);
                    for (int calcVal1 : calc1) {
                        for (int calcVal2 : calc2) {
                            result.add(operations.get(expression.charAt(i)).apply(calcVal1, calcVal2));
                        }
                    }
                }
            }

            if (result.isEmpty()) {
                result.add(Integer.parseInt(expression.substring(l, r + 1)));
            }

            memo[l][r] = result;
        }
        return memo[l][r];
    }
}
