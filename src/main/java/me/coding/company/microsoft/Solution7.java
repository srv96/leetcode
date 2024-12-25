package me.coding.company.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution7 {
    public String multiply(String num1, String num2) {
        char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
        int n1Size = n1.length, n2Size = n2.length;
        List<List<Integer>> sumMatrix = new ArrayList<>();
        for (int i = n2Size - 1; i >= 0; i--) {
            int carry = 0;
            List<Integer> row = new ArrayList<>();
            for (int j = n1Size - 1; j >= 0; j--) {
                int digitMul = Integer.parseInt(String.valueOf(n2[i])) * Integer.parseInt(String.valueOf(n1[j]));
                row.add((digitMul + carry) % 10);
                carry = (digitMul + carry) / 10;
            }
            while (carry != 0) {
                row.add(carry % 10);
                carry /= 10;
            }
            Collections.reverse(row);
            for (int j = 0; j < n2Size - 1 - i; j++) {
                row.add(0);
            }
            sumMatrix.add(row);
        }
        int size = sumMatrix.size();
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            maxLen = Math.max(maxLen, sumMatrix.get(i).size());
        }
        for (int i = 0; i < size; i++) {
            List<Integer> row = sumMatrix.get(i);
            int diff = maxLen - sumMatrix.get(i).size();
            for (int j = 0; j < diff; j++) {
                row.add(0, 0);
            }
        }
        int carry = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = maxLen - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < size; j++) {
                sum += sumMatrix.get(j).get(i);
            }
            result.add((sum + carry) % 10);
            carry = (sum + carry) / 10;
        }
        while (carry != 0) {
            result.add(carry % 10);
            carry /= 10;
        }
        Collections.reverse(result);
        StringBuilder resStr = new StringBuilder();
        for (Integer ele : result) {
            resStr.append(ele);
        }
        while (resStr.charAt(0) == '0' && resStr.length() > 1) resStr.deleteCharAt(0);
        return resStr.toString();
    }
}
