package me.coding.company.microsoft;

public class Relation {
    int[][] relation;

    public Relation() {
        this.relation = new int[][]{{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};
    }

    public boolean knows(int a, int b) {
        return relation[a][b] == 1;
    }
}
