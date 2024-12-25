package me.coding.leetcode.top150;

import java.util.Stack;

class Solution60 {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        Stack<Integer> minStack = new Stack<>();
        int[] leftBoundary = new int[size];
        int[] rightBoundary = new int[size];
        int maxArea = Integer.MIN_VALUE;

        for (int i = size - 1; i >= 0; i--) {
            while (!minStack.isEmpty()) {
                if (heights[i] <= heights[minStack.peek()]) minStack.pop();
                else break;
            }
            if (minStack.isEmpty()) {
                minStack.push(i);
                rightBoundary[i] = size;
            } else {
                rightBoundary[i] = minStack.peek();
                minStack.push(i);
            }
        }
        minStack.clear();
        for (int i = 0; i < size; i++) {
            while (!minStack.isEmpty()) {
                if (heights[i] <= heights[minStack.peek()]) minStack.pop();
                else break;
            }
            if (minStack.isEmpty()) {
                minStack.push(i);
                leftBoundary[i] = -1;
            } else {
                leftBoundary[i] = minStack.peek();
                minStack.push(i);
            }
        }
        for (int i = 0; i < size; i++)
            maxArea = Math.max(maxArea, heights[i] * (rightBoundary[i] - leftBoundary[i] - 1));
        return maxArea;
    }
}
