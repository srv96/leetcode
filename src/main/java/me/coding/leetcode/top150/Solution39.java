//package me.coding.leetcode.top150;
//
//import javafx.util.Pair;
//
//import java.util.*;
//
//class Solution39 {
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        int size = equations.size();
//        int qSize = queries.size();
//        Map<String, List<Pair<String,Double>>> graph = new HashMap<>();
//        HashMap<String,Boolean> visitMap = new HashMap<>();
//
//        for(int i = 0 ; i < size ; i++){
//            if (graph.get(equations.get(i).get(0)) == null) {
//                List<Pair<String,Double>> neighbours = new ArrayList<>();
//                neighbours.add(new Pair<>(equations.get(i).get(1),values[i]));
//                graph.put(equations.get(i).get(0),neighbours);
//                visitMap.put(equations.get(i).get(0),false);
//            } else {
//                List<Pair<String,Double>> neighbours = graph.get(equations.get(i).get(0));
//                neighbours.add(new Pair<>(equations.get(i).get(1),values[i]));
//                graph.put(equations.get(i).get(0),neighbours);
//                visitMap.put(equations.get(i).get(0),false);
//            }
//            if (graph.get(equations.get(i).get(1)) == null) {
//                List<Pair<String,Double>> neighbours = new ArrayList<>();
//                neighbours.add(new Pair<>(equations.get(i).get(0),1/values[i]));
//                graph.put(equations.get(i).get(1),neighbours);
//                visitMap.put(equations.get(i).get(1),false);
//            } else {
//                List<Pair<String,Double>> neighbours = graph.get(equations.get(i).get(1));
//                neighbours.add(new Pair<>(equations.get(i).get(0),1/values[i]));
//                graph.put(equations.get(i).get(1),neighbours);
//                visitMap.put(equations.get(i).get(1),false);
//            }
//        }
//
//        double[] results = new double[qSize];
//
//        for(int i = 0 ; i < qSize ; i++){
//            visitMap.replaceAll((key, value) -> false);
//            results[i] = graph.containsKey(queries.get(i).get(0))&&graph.containsKey(queries.get(i).get(1)) ? evaluate(graph,visitMap,queries.get(i).get(0),queries.get(i).get(1)) : -1;
//        }
//        return results;
//    }
//
//    private Double evaluate(Map<String, List<Pair<String, Double>>> graph,HashMap<String,Boolean> visitMap, String start,String end) {
//        visitMap.put(start,true);
//        for(Pair<String,Double> node : graph.get(start)){
//            if(node.getKey().equals(end))return node.getValue();
//            else if(!visitMap.get(node.getKey())){
//                double subResult = node.getValue() * evaluate(graph,visitMap, node.getKey(), end);
//                if(subResult<=0.0)continue;
//                else return subResult;
//            }
//        }
//        return -1.0;
//    }
//}
