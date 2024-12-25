package me.coding.company.visa;

class Solution9 {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int row = boxGrid.length;
        int col = boxGrid[0].length;
        for (int i = 0; i < row; i++) {
            shiftStoneIfPresent(boxGrid[i]);
        }
        char[][] result = new char[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                result[i][j] = boxGrid[row - j - 1][i];
            }
        }
        return result;
    }

    private void shiftStoneIfPresent(char[] row) {
        int len = row.length;
        for (int i = len - 1; i >= 0; i--) {
            if (row[i] == '#') {
                int stonepos = i;
                while (stonepos + 1 < len && row[stonepos + 1] != '*' && row[stonepos + 1] != '#') stonepos++;
                row[i] = '.';
                row[stonepos] = '#';
            }
        }
    }
}
