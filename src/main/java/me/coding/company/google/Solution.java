package me.coding.company.google;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> result;

    public List<String> validStrings(int n) {
        result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        findAllString(sb, 0, n);
        return result;
    }

    private void findAllString(StringBuilder sb, int i, int n) {
        if (i == n) {
            result.add(sb.toString());
        } else {
            if (i == 0) {
                sb.append("0");
                findAllString(sb, i + 1, n);
                sb.deleteCharAt(0);
                sb.append("1");
                findAllString(sb, i + 1, n);
                sb.deleteCharAt(0);
            } else {
                char ch = sb.charAt(sb.length() - 1);
                if (ch == '0') {
                    sb.append("1");
                    findAllString(sb, i + 1, n);
                    sb.deleteCharAt(i);
                } else {
                    sb.append("0");
                    findAllString(sb, i + 1, n);
                    sb.deleteCharAt(i);
                    sb.append("1");
                    findAllString(sb, i + 1, n);
                    sb.deleteCharAt(i);
                }
            }
        }
    }
}
