package me.coding.sandbox;

import me.coding.ds.pair.Pair;

import java.util.*;

public class DijktraAlgorithm {
    Map<Integer, List<Pair<Integer, Integer>>> getGraph() {
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();
        graph.put(1, new ArrayList<>(Arrays.asList(new Pair<>(2, 2), new Pair<>(3, 4))));
        graph.put(2, new ArrayList<>(Arrays.asList(new Pair<>(3, 1), new Pair<>(4, 7),new Pair<>(5,1))));
        graph.put(3, new ArrayList<>(Arrays.asList(new Pair<>(5, 3))));
        graph.put(4, new ArrayList<>(Arrays.asList(new Pair<>(6, 1))));
        graph.put(5, new ArrayList<>(Arrays.asList(new Pair<>(4, 2), new Pair<>(6, 5), new Pair<>(3, 3))));
        graph.put(6, new ArrayList<>());
        return graph;
    }

    public int getShortestPath(Map<Integer, List<Pair<Integer, Integer>>> graph, int n, int source, int destination) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(pair -> pair.value));
        Map<Integer, Pair<Integer, Integer>> pairMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            Pair<Integer, Integer> pair = new Pair<>(i, Integer.MAX_VALUE);
            pairMap.put(i, pair);
        }
        pairMap.get(source).value = 0;
        pq.add(pairMap.get(source));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            List<Pair<Integer, Integer>> conn = graph.get(pair.key);
            for (Pair<Integer, Integer> connPair : conn) {
                int newDistance = pairMap.get(pair.key).value + connPair.value;
                if (pairMap.get(connPair.key).value > newDistance) {
                    pairMap.get(connPair.key).value = newDistance;
                    pq.add(connPair);
                }
            }
        }
        return pairMap.get(destination).value;
    }

    public static void main(String[] args) {
        DijktraAlgorithm dj = new DijktraAlgorithm();
        Map<Integer, List<Pair<Integer, Integer>>> graph = dj.getGraph();
        int result = dj.getShortestPath(graph, 6, 1, 6);
        System.out.println(result);
    }
}
