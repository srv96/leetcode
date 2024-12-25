package me.coding.company.google;

import java.util.Arrays;

class Solution26 {
    int[] arr;
    int max;
    public Solution26(int[] w) {
        this.arr = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            this.arr[i] = i > 0 ? arr[i - 1] + w[i] : w[i];
        }
        this.max = arr[arr.length - 1];
    }

    private static int findIndex(int[] sortedArray, int number) {
        int index = Arrays.binarySearch(sortedArray, number);
        if (index < 0) {
            index = -(index + 1);
        } else {
            while (index < sortedArray.length && sortedArray[index] == number) {
                index++;
            }
        }
        return index;
    }

    public int pickIndex() {
        int random = (int) (Math.random() * max);
        return findIndex(this.arr,random);
    }
}
