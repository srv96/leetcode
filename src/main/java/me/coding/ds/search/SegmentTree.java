package me.coding.ds.search;

import java.util.Arrays;

public class SegmentTree {
    public  double[] segment;
    public int n, maxSize;

    public SegmentTree(int[] arr) {
        this.n = arr.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        this.maxSize = 2 * (int) Math.pow(2, height) - 1;
        this.segment = new double[maxSize];
        Arrays.fill(this.segment , Double.MAX_VALUE);
        buildTree(arr, 0, n - 1, 0);
    }

    private double buildTree(int[] arr, int l, int r, int idx) {
        if (l == r) segment[idx] = arr[l];
        else {
            int mid = l + (r - l) / 2;
            segment[idx] = buildTree(arr, l, mid, 2 * idx + 1) + buildTree(arr, mid + 1, r, 2 * idx + 2);
        }
        return segment[idx];
    }

    public double getSum(int l, int r) {
        return query(l, r, 0, n - 1, 0);
    }

    private double query(int l, int r, int start, int end, int idx) {
        if (l <= start && r >= end) return segment[idx];
        if (r < start || l > end) return 0;
        else {
            int mid = start + (end - start) / 2;
            return query(l, r, start, mid, 2 * idx + 1) + query(l, r, mid + 1, end, 2 * idx + 2);
        }
    }
}
