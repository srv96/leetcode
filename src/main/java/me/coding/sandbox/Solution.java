package me.coding.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 3, 5, 7, 6, 8, 9, 7, 6, 4, 6, 5, 2, 3, 8, 7, 3, 5, 1));
        List<Integer> result = new Solution().processData(list);
        System.out.println(list);
        System.out.println(result);
    }

    private  List<Integer> processData(List<Integer> list) {
//        ForkJoinPool fjPool = new ForkJoinPool();
//        try {
//            return fjPool.submit(()-> list.stream().unordered().parallel().map(x -> CompletableFuture.supplyAsync(()->processElement(x))).collect(Collectors.toList())
//            ).get().stream().map(CompletableFuture::join).collect(Collectors.toList());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }finally {
//            fjPool.shutdown();
//        }
        List<Integer> result = new ArrayList<>();
        list.stream().unordered().parallel().forEach(x -> result.add(processElement(x)));
        return result;
    }

    public int processElement(Integer element){
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return element * 2;
    }
}
