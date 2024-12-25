package me.coding.leetcode.top150;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution34 {
    public String simplifyPath(String path) {
        Deque<String> directoryDeque = new ArrayDeque<>();
        String[] directoriesPath = path.split("/");

        for(String directory : directoriesPath){
            if(directory==null||directory.equals("")|| directory.equals("."))continue;
            if(directory.equals("..")){
                if(!directoryDeque.isEmpty())directoryDeque.removeLast();
            }
            else directoryDeque.addLast(directory);
        }

        String result = "";
        while(!directoryDeque.isEmpty()){
            result+="/"+directoryDeque.removeFirst();
        }
        return result.equals("") ? "/" :result;
    }
}
