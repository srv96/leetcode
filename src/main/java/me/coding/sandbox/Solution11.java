package me.coding.sandbox;

import java.util.*;

public class Solution11 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        List<Integer> result = processParallel(list);
        System.out.println(result);
    }

    private static List<Integer> processParallel(List<Integer> list) {
        List<Integer> result = Collections.synchronizedList(new ArrayList<>());

        list.stream().unordered().parallel().forEach(x -> {
            try {
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            result.add(x * 2);
        });
        return result;
    }
}
