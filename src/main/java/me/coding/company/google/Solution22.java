package me.coding.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution22 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int qSize = l.length;
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < qSize; i++) {
            result.add(checkArithmetic(Arrays.copyOfRange(nums, l[i], r[i]+1)));
        }
        return result;
    }

    private Boolean checkArithmetic(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        if (size <= 2) return true;
        for (int i = 2; i < size; i++) {
            if (nums[i] - nums[i - 1] != nums[1] - nums[0])return false;
        }
        return true;
    }
}
