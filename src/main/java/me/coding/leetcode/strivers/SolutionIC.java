package me.coding.leetcode.strivers;

import java.util.ArrayList;
import java.util.List;

class SolutionIC {
    public List<List<String>> partition(String s) {
        char[] charArr = s.toCharArray();
        List<List<String>> result = partitions(0,charArr);
        return result;
    }

    private List<List<String>> partitions(int idx, char[] charArr) {
        if (idx >= charArr.length) {
            List<List<String>> seed = new ArrayList<>();
            seed.add(new ArrayList<>());
            return seed;
        }
        return null;
    }
}
