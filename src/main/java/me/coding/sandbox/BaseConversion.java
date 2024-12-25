package me.coding.sandbox;

import java.util.Arrays;

public class BaseConversion {

    public static void main(String[] args) {
        // Test cases
        int[] numbers = {10, 15, 7}; // Example input array
        int actualBase = 16; // Example actual base (hexadecimal)
        int desiredBase = 2; // Example desired base (binary)

        int[] result = convertBase(numbers, actualBase, desiredBase);
        System.out.println("Result: " + Arrays.toString(result));

        // Additional test cases
        int[] numbers2 = {10, 15, 7}; // Example input array
        int actualBase2 = 16; // Example actual base (hexadecimal)
        int desiredBase2 = 16; // Example desired base (hexadecimal)

        int[] result2 = convertBase(numbers2, actualBase2, desiredBase2);
        System.out.println("Result: " + Arrays.toString(result2));

        int[] numbers3 = {1, 2, 3, 4, 5}; // Example input array
        int actualBase3 = 10; // Example actual base (decimal)
        int desiredBase3 = 8; // Example desired base (octal)

        int[] result3 = convertBase(numbers3, actualBase3, desiredBase3);
        System.out.println("Result: " + Arrays.toString(result3));

        int[] numbers4 = {1, 2, 3, 4, 5}; // Example input array
        int actualBase4 = 10; // Example actual base (decimal)
        int desiredBase4 = 16; // Example desired base (hexadecimal)

        int[] result4 = convertBase(numbers4, actualBase4, desiredBase4);
        System.out.println("Result: " + Arrays.toString(result4));
    }

    public static int[] convertBase(int[] numbers, int actualBase, int desiredBase) {
        int[] result = new int[numbers.length * (int)(Math.log(actualBase) / Math.log(desiredBase)) + 1];
        int[] temp = new int[numbers.length * (int)(Math.log(actualBase) / Math.log(desiredBase)) + 1];
        int index = 0;
        for (int number : numbers) {
            while (number > 0) {
                int remainder = number % desiredBase;
                temp[index++] = remainder;
                number /= desiredBase;
            }
            while (index > 0) {
                result[result.length - index] = temp[--index];
            }
        }
        return result;
    }
}

