package me.coding.sandbox;

import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5,5,6, 7, 9, 11, 13}; // Example sorted array
        int number = 6; // Example input number

        int resultIndex = findIndex(sortedArray, number);
        System.out.println("Index of the smallest number larger than " + number + " is: " + resultIndex);
    }

    public static int findIndex(int[] sortedArray, int number) {
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
}
