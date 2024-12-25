package me.coding.sandbox;

import java.util.Arrays;

class Matrix{

    public int[][] getArr() {
        return arr;
    }

    public int[][] arr;
    public Matrix(int[][] arr) {
        this.arr = arr;
    }

    public Matrix dot(Matrix m2){
        int[][] arr2 = m2.getArr();

        int row1 = arr.length;
        int row2 = arr2.length;

        int col1 = arr[0].length;
        int col2 = arr2[0].length;

        int[][] result = new int[row1][col2];

        for(int i = 0 ; i < result.length;i++){
            Arrays.fill(result[i],0);
        }

        for(int i = 0 ; i < row1 ; i++){
            for(int j = 0 ; j < col2 ; j++){
                for(int k = 0 ; k < col1 ; k++){
                    result[i][j]+=(arr[i][k]*arr2[k][j]);
                }
            }
        }

        return new Matrix(result);
    }
}
