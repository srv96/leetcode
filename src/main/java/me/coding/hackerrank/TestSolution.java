package me.coding.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TestSolution {
    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        List<String> r1 = new ArrayList<>();
        r1.add("P1:a");
        r1.add("P3:b");
        r1.add("P5:x");
        result.add(r1);
        r1 = new ArrayList<>();
        r1.add("P1:b");
        r1.add("P2:q");
        r1.add("P5:x");
        result.add(r1);
        Solution5.compute(result);
    }
}
