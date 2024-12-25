package me.coding.company.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution9 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        combSum(candidates, path, 0, target);
        return result;
    }
    private void combSum(int[] candidates, List<Integer> path, int idx, int target) {
        if (idx >= candidates.length) return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        } else {
            if (candidates[idx] > target) return;
            else {
                path.add(candidates[idx]);
                combSum(candidates, path, idx, target - candidates[idx]);
                path.remove(path.size() - 1);
                combSum(candidates, path, idx + 1, target);
            }
        }
    }
}
