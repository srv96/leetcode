package me.coding.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int maximumGap(int[] nums) {
        int size = nums.length;
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        List<Integer>[] lists = new List[size - 1];
        for (int i = 0; i < size - 1; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            int bucketNumber = getBucketNum(nums[i], min, max, size-2);
            System.out.print(bucketNumber+" ");
            lists[bucketNumber].add(nums[i]);
        }
        System.out.println("");
        return 0;
    }

    private int getBucketNum(int num, int min, int max, int numBucket) {
        num -= min;
        int range = max - min;
        double subrange = (double)range / (double)numBucket;
        num /=subrange;
        return num;
    }
}
