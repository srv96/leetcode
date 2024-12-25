package me.coding.leetcode.code;

class Solution24 {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(rows==0||cols==0)return 0;
        int maxArea = 0;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(grid[i][j]==1){
                    int area = calculateArea(grid,i,j,rows,cols);
                    maxArea = maxArea > area ? maxArea : area;
                }
            }
        }
        return maxArea;
    }
    private boolean isValidCell(int i , int j,int rows,int cols){
        return i>=0&&i<rows&&j>=0&&j<cols;
    }
    private int calculateArea(int[][] grid, int i, int j,int rows,int cols) {
       if(!isValidCell(i,j,rows,cols)){
           return 0;
       }else{
           if(grid[i][j]==1){
               grid[i][j]=2;
               return calculateArea(grid,i-1,j,rows,cols)
                       +calculateArea(grid,i,j-1,rows,cols)
                       +calculateArea(grid,i,j+1,rows,cols)
                       +calculateArea(grid,i+1,j,rows,cols)
                       +1;
           }
           else return 0;
       }
    }
}
