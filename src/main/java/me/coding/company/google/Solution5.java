package me.coding.company.google;

import java.util.*;

class Solution5 {
    class Word{
        public String word;
        public int freq;

        public Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> memo = new HashMap<>();
        for(String word : words){
            if(!memo.containsKey(word))memo.put(word,1);
            else memo.put(word,memo.get(word)+1);
        }
        PriorityQueue<Word> queue = new PriorityQueue<>(Comparator.comparingInt((Word w) -> w.freq).reversed().thenComparing((Word w) -> w.word));
        for(String word : memo.keySet()){
            queue.add(new Word(word,memo.get(word)));
        }
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < k ; i++){
            result.add(queue.poll().word);
        }
        return result;
    }
}
