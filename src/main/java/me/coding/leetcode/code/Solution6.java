package me.coding.leetcode.code;

public class Solution6 {
    public int strStr(String haystack, String needle) {
        int subSize = needle.length();
        int size = haystack.length();
        for(int i = 0 ; i <= size-subSize ; i++){
            if(haystack.substring(i,i+subSize).equals(needle))return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();
        int result  = s.strStr("abc","c");
        System.out.println(result);
    }
}
