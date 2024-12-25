package me.coding.company.walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution12 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int size = asteroids.length;
        for (int i = 0; i < size; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                boolean rightDestroid = false;
                while (!stack.isEmpty()) {

                    if (stack.peek() < 0) {
                        stack.push(asteroids[i]);
                        rightDestroid = true;
                        break;
                    }

                    int nearLeft = stack.pop();
                    int lMag = getLargerMagnitude(nearLeft, asteroids[i]);

                    if (nearLeft == lMag) {
                        stack.push(nearLeft);
                        rightDestroid = true;
                        break;
                    } else if (lMag == 0) {
                        rightDestroid = true;
                        break;
                    } else {
                        continue;
                    }

                }
                if (!rightDestroid) {
                    stack.push(asteroids[i]);
                }
            }
        }
        List<Integer> list = new ArrayList<>(stack);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int getLargerMagnitude(int num1, int num2) {
        if (Math.abs(num1) == Math.abs(num2)) return 0;
        else return Math.abs(num1) > Math.abs(num2) ? num1 : num2;
    }
}
