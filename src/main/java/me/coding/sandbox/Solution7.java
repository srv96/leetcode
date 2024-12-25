package me.coding.sandbox;

public class Solution7 {
    public int[] sort(int[] num) {
        int len = num.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if(num[i]<num[j]){
                    num[i]+=num[j];
                    num[j] = num[i]-num[j];
                    num[i] = num[i]-num[j];
                }
            }
        }
        return num;
    }
    public int[] getDiagonal(int[][][] cube){
        int len = cube.length;
        int breadth = cube[0].length;
        int height = cube[0][0].length;
        int min = Math.min(len,Math.min(breadth,height));
        int[] result= new int[min];
        for(int i = 0 ; i < min ; i++){
            result[min-1-i] = cube[i][i][i];
        }
        return result;
    }

}

