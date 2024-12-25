package me.coding.sandbox;

import me.coding.ds.pair.Pair;

import java.util.HashMap;
import java.util.Map;

public class BellmanFordAlgorithm {
    public Map<Pair<Integer, Integer>, Integer> getGraph() {
        Map<Pair<Integer, Integer>, Integer> graph = new HashMap<>();
        graph.put(new Pair<>(1, 2), 6);
        graph.put(new Pair<>(1, 3), 5);
        graph.put(new Pair<>(1, 4), 5);
        graph.put(new Pair<>(2, 5), -1);
        graph.put(new Pair<>(3, 2), -2);
        graph.put(new Pair<>(3, 5), 1);
        graph.put(new Pair<>(4, 3), -2);
        graph.put(new Pair<>(4, 6), -1);
        graph.put(new Pair<>(5, 7), 3);
        graph.put(new Pair<>(6, 7), 3);
        return graph;
    }

    public int getShortestPath(Map<Pair<Integer, Integer>, Integer> graph, int n, int source, int destination) {
        Map<Integer, Integer> distance = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            distance.put(i,Integer.MAX_VALUE);
        }
        distance.put(source,0);
        for(int i = 1 ; i <= n ; i++){
            for(Pair<Integer,Integer> pair : graph.keySet()){
                if(distance.get(pair.key)==Integer.MAX_VALUE)continue;
                else{
                    if(distance.get(pair.key)+graph.get(pair) < distance.get(pair.value)){
                        distance.put(pair.value,distance.get(pair.key)+graph.get(pair));
                    }
                }
            }
        }
        return distance.get(destination);
    }

    public static void main(String[] args) {
        BellmanFordAlgorithm blAlg = new BellmanFordAlgorithm();
        Map<Pair<Integer, Integer>, Integer> graph = blAlg.getGraph();
        int result = blAlg.getShortestPath(graph,7,1,7);
        System.out.println(result);
    }
}
