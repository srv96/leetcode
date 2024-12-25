package me.coding.leetcode.top150;

class Solution5 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int tgti = 0;
        int tgtj = matrix[0].length-1;

        while(tgti < matrix.length && tgtj >=0){
            if(matrix[tgti][tgtj]==target)return true;
            else{
                if(matrix[tgti][tgtj] > target)tgtj--;
                else tgti++;
            }
        }
        return false;
    }
}
