package me.coding.company.google;

import me.coding.ds.set.DSU;

class Solution17 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            if(leftChild[i]!=-1){
                dsu.union(i,leftChild[i]);
            }
            if(rightChild[i]!=-1)dsu.union(i,rightChild[i]);
        }
        if(dsu.countParent()>1)return false;
        else return true;
    }

}