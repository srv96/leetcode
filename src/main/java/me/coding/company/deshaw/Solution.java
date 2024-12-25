package me.coding.company.deshaw;

class Solution {
    private  int calculateRowHash(int[] row) {
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < row.length; i++) {
            if (i % 2 == 0) {
                sumEven += row[i];
            } else {
                sumOdd += row[i];
            }
        }
        return sumEven - sumOdd;
    }

    public int[] calculateRowHashes(int[][] matrix) {
        int numRows = matrix.length;
        int[] rowHashes = new int[numRows];

        for (int i = 0; i < numRows; i++) {
            rowHashes[i] = calculateRowHash(matrix[i]);
        }

        return rowHashes;
    }

    public  int[] calculateColumnHashes(int[][] matrix) {
        int numCols = matrix[0].length; // Assuming all rows have the same number of columns
        int[] columnHashes = new int[numCols];

        for (int j = 0; j < numCols; j++) {
            int[] column = extractColumn(matrix, j);
            columnHashes[j] = calculateRowHash(column);
        }

        return columnHashes;
    }

    private int[] extractColumn(int[][] matrix, int columnIndex) {
        int numRows = matrix.length;
        int[] column = new int[numRows];

        for (int i = 0; i < numRows; i++) {
            column[i] = matrix[i][columnIndex];
        }

        return column;
    }

    public int equalPairs(int[][] grid) {
        int[] rowHash = calculateRowHashes(grid);
        int[] colHash = calculateColumnHashes(grid);
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int count = 0;
        for(int i = 0 ; i < rowSize; i++){
            for(int j = 0 ; j < colSize ; j++){
                if(rowHash[i]==colHash[j]){
                    boolean isSame = true;
                    for(int k = 0 ; k < rowSize ; k++){
                        if(grid[i][k]!=grid[k][j]){
                            isSame=false;
                            break;
                        }
                    }
                    if(isSame)count++;
                }
            }
        }
        return count;
    }
}
