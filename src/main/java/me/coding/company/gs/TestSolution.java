package me.coding.company.gs;

import java.util.ArrayList;
import java.util.List;

public class TestSolution {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> row = new ArrayList<>(List.of(1, 1, 0, 1));matrix.add(row);
//        row = new ArrayList<>(List.of(0, 1, 1, 1));matrix.add(row);
//        row = new ArrayList<>(List.of(1, 0, 0, 1));matrix.add(row);
        System.out.println(Solution.countConnections(matrix));
    }
}
