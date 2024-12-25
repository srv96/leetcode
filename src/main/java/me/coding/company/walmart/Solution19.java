package me.coding.company.walmart;

import java.util.*;

class Solution19 {
    Set<List<Integer>> lstSet;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        lstSet = new TreeSet<>((o1, o2) -> {
            if (o1.size() != o2.size()) {
                return Integer.compare(o1.size(), o2.size());
            }
            for (int i = 0; i < o1.size(); i++) {
                int cmp = Integer.compare(o1.get(i), o2.get(i));
                if (cmp != 0) return cmp;
            }
            return 0; // Treat as equal if all elements are identical
        });
        List<List<Integer>> result = getComb(candidates, 0, target);
        if(result==null)return new ArrayList<>();

        lstSet.addAll(result);
        return new ArrayList<>(lstSet);
    }

    private List<List<Integer>> getComb(int[] candidates, int i, int target) {
        if (i >= candidates.length || target < candidates[i]) return null;

        if (target == candidates[i]) {
            List<List<Integer>> seed = new ArrayList<>();
            seed.add(new ArrayList<>(Arrays.asList(candidates[i])));
            return seed;
        }

        List<List<Integer>> subResult = new ArrayList<>();
        List<List<Integer>> subResult1, subResult2;

        subResult1 = getComb(candidates, i + 1, target);
        if (subResult1 != null && !subResult1.isEmpty()) {
            for (List<Integer> lst : subResult1) {
                if (lst != null && !lst.isEmpty()) {
                    subResult.add(lst);
                }
            }
        }

        subResult2 = getComb(candidates, i + 1, target - candidates[i]);
        if (subResult2 != null && !subResult2.isEmpty()) {
            for (List<Integer> lst : subResult2) {
                lst.add(candidates[i]);
                subResult.add(lst);
            }
        }

        return subResult;

    }
}