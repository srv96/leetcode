package me.coding.hackerrank;

import java.io.*;
import java.util.*;

public class Solution1 {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        int count = 0;
        char[] str = s.toCharArray();
        char even = 0,odd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; ((i - j >= 0) && (i + j < n)); j++) {
                if(j==0){
                    count++;
                }
                else if(j==1 && str[i-j]==str[i+j]){
                    count++;
                    odd = str[i-j];
                }
                else if(j>1 && str[i-j]==odd && str[i+j]==odd){
                    count++;
                }
                else break;
            }
            if ((i < n - 1) && (str[i] == str[i + 1])) {
                for (int j = 0; ((i - j >= 0) && (i + 1 + j < n)); j++) {
                    if(j==0 && str[i]==str[i+1]){
                        count++;
                        even = str[i];
                    } else if (j>0 && str[i-j]==even && str[i+1+j]==even) {
                        count++;
                    }
                    else break;
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String input = "mnonopoo";
        int size = input.length();
        System.out.println(substrCount(size, input));
    }
}

