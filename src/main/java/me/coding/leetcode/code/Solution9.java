package me.coding.leetcode.code;

import java.util.ArrayList;
import java.util.List;

class Solution9 {

    public void gp(int open, int close, int lvl, int max, String seq, List<String> seqs) {
        if (open == 0) {
            seq += "(";
            open++;
            lvl++;
        }
        if (open > 0 && open < max && open >= close) {
            gp(open + 1, close, lvl + 1, max, seq + "(", seqs);
            gp(open - 1, close + 1, lvl, max, seq + ")", seqs);
        } else {
            seqs.add(seq);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gp(0, 0, 0, n, "", result);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {

        Solution9 s = new Solution9();
        s.generateParenthesis(3);
    }
}
