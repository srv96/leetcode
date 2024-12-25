package me.coding.leetcode.top150;

class Solution37 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int rowPos=0;
        int colPos = colSize-1;

        while(rowPos < rowSize && colPos >=0){
            if(matrix[rowPos][colPos]==target)return true;

            if(target > matrix[rowPos][colPos])rowPos++;
            else colPos--;
        }
        return false;

    }
}
