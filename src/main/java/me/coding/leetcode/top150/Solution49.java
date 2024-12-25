package me.coding.leetcode.top150;

class Solution49 {
    private int heapPop(int[] array, int size) {
        if (size == 0) return Integer.MIN_VALUE;

        int result = array[0];
        array[0] = array[size - 1];
        heapify(array, size - 1, 0);
        return result;
    }

    private void buildHeap(int[] array) {
        int size = array.length;
        int startIdx = (size / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            heapify(array, size, i);
        }
    }

    private void heapify(int[] array, int size, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < size && r < size) largest = array[l] > array[largest] ? array[l] > array[r] ? l : r : largest;
        if (l < size) largest = array[l] > array[largest] ? l : largest;
        if (r < size) largest = array[r] > array[largest] ? r : largest;

        if (largest != i) {
            array[i] = array[i] ^ array[largest] ^ (array[largest] = array[i]);
            heapify(array, size, largest);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);
        int varSize = nums.length;
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = heapPop(nums, varSize);
            varSize--;
        }
        return result;
    }
}
