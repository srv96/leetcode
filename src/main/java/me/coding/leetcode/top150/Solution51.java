package me.coding.leetcode.top150;

import java.util.*;

public class Solution51 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < size1 ; i++)queue.offer(new int[] {i,0,nums1[i]+nums2[0]});
        while (!queue.isEmpty() && k > 0) {
            int[] prevMin = queue.poll();
            result.add(new ArrayList<>(Arrays.asList(nums1[prevMin[0]], nums2[prevMin[1]])));
            if (prevMin[1] + 1 < size2)queue.offer(new int[]{prevMin[0], prevMin[1] + 1, nums1[prevMin[0]] + nums2[prevMin[1] + 1]});
            k--;
        }
        return result;
    }
}
//
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        int size1 = nums1.length;
//        int size2 = nums2.length;
//        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
//        Set<List<Integer>> visitedPair = new HashSet<>();
//        queue.add(new int[]{0, 0, nums1[0] + nums2[0]});
//        visitedPair.add(Arrays.asList(0, 0));
//        List<List<Integer>> result = new ArrayList<>();
//        while (!queue.isEmpty() && k > 0) {
//            int[] prevMin = queue.poll();
//            result.add(new ArrayList<>(Arrays.asList(nums1[prevMin[0]], nums2[prevMin[1]])));
//            if (prevMin[0] + 1 < size1 && !visitedPair.contains(Arrays.asList(prevMin[0] + 1, prevMin[1]))) {
//                visitedPair.add(Arrays.asList(prevMin[0] + 1, prevMin[1]));
//                queue.offer(new int[]{prevMin[0] + 1, prevMin[1], nums1[prevMin[0] + 1] + nums2[prevMin[1]]});
//            }
//            if (prevMin[1] + 1 < size2 && !visitedPair.contains(Arrays.asList(prevMin[0], prevMin[1] + 1))) {
//                visitedPair.add(Arrays.asList(prevMin[0], prevMin[1] + 1));
//                queue.offer(new int[]{prevMin[0], prevMin[1] + 1, nums1[prevMin[0]] + nums2[prevMin[1] + 1]});
//            }
//            k--;
//        }
//        return result;
//    }
