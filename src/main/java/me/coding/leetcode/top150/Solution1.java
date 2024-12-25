package me.coding.leetcode.top150;

class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m+=n;
        if (m == 0 && n == 0) {
            return;
        } else if (m == n) {
            for (int i = 0; i < m; i++) {
                nums1[i] = nums2[i];
            }
        } else if (m == 0) {
            return;
        } else {
            int[] mn = new int[m];
            int i = 0, j = 0, k = 0;
            while (i < m - n && j < n) {
                if (nums1[i] <= nums2[j]) {
                    mn[k] = nums1[i];
                    i++;
                    k++;
                } else {
                    mn[k] = nums2[j];
                    j++;
                    k++;
                }
            }
            while (i < m - n) {
                mn[k] = nums1[i];
                i++;
                k++;
            }
            while (j < n) {
                mn[k] = nums2[j];
                j++;
                k++;
            }

            for (int idx = 0; idx < nums1.length; idx++) {
                nums1[idx] = mn[idx];
            }
        }
    }
}
