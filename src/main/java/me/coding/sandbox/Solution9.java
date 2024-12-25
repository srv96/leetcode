package me.coding.sandbox;

import java.util.Arrays;

public class Solution9 {
    boolean[][] pathFlag;
    public boolean isStringAvailable(char[][] charMatrix, String input) {
        char[] inputArr = input.toCharArray();
        int size = input.length();
        int rowSize = charMatrix.length;
        int colSize = charMatrix[0].length;
        pathFlag = new boolean[rowSize][colSize];
        for(int i = 0 ; i < rowSize ; i++){
            Arrays.fill(pathFlag[i],false);
        }
        for(int i = 0 ; i < rowSize ; i++){
            for(int j = 0 ; j < colSize ; j++){
                if(charMatrix[i][j]==input.charAt(0)){
                    if(checkExist(charMatrix,rowSize,colSize,inputArr,i ,j,0,size)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkExist(char[][] charMatrix,int rowSize,int colSize, char[] inputArr, int i, int j,int idx, int size) {
        if(!(i>=0&&i<rowSize&&j>=0&&j<colSize))return false;
        if(idx==size)return true;
        if(pathFlag[i][j])return false;
        if(charMatrix[i][j]==inputArr[idx]){
            pathFlag[i][j] = true;
            boolean result = checkExist(charMatrix,rowSize,colSize,inputArr,i-1,j,idx+1,size)||
                    checkExist(charMatrix,rowSize,colSize,inputArr,i,j-1,idx+1,size)||
                    checkExist(charMatrix,rowSize,colSize,inputArr,i,j+1,idx+1,size)||
                    checkExist(charMatrix,rowSize,colSize,inputArr,i+1,j,idx+1,size);
            pathFlag[i][j] = false;
            return result;
        }
        return false;
    }
}
