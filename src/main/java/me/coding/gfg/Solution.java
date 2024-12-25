package me.coding.gfg;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<String> corpus = new HashSet<>();

    public String findString(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                stringBuilder.append(i);
            }
            return stringBuilder.toString();
        } else {
            String init = "";
            for (int i = 0; i < k; i++) {
                init+="0";
            }
            stringBuilder.append(init);
            corpus.add(init);
            getString(stringBuilder, n, k);
        }
        return stringBuilder.toString();
    }

    private StringBuilder getString(StringBuilder stringBuilder, int n, int k) {
        String baseString = stringBuilder.substring(stringBuilder.length() - (k - 1));
        for (int i = n - 1; i >= 0; i--) {
            if (!corpus.contains(baseString + i)) {
                stringBuilder.append(i);
                corpus.add(baseString + i);
                getString(stringBuilder, n, k);
                break;
            }
        }
        return stringBuilder;
    }
}
