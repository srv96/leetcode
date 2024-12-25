package me.coding.leetcode.top150;

import java.util.*;

class Solution42 {
    Set<String> memo = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)){
            memo.add(s);
            return true;
        }
        for(int i = 0 ; i < wordDict.size() ; i++){
            if(s.indexOf(wordDict.get(i))==0){
                if(memo.contains(s.substring(wordDict.get(i).length())))return false;
                else{
                    String subString =s.substring(wordDict.get(i).length());
                    if(wordBreak(subString,wordDict)){
                        return true;
                    }else{
                        memo.add(subString);
                    }
                }
            }
        }
        return false;
    }
}
