package me.coding.sandbox;


public class Solution10 {
    int count = 0 ;

    public void f1(){
        int j = count;
        j++;
        count = j;
    }

    public void f2(){
        f1();
        f1();
        f1();
    }

    public void f3(){
        f1();
        f1();
        f1();
        f1();
        f1();
    }




}
