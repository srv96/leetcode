package me.coding.hackerrank;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sandbox {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> lstCpy = new ArrayList<>(lst);
        lstCpy.add(5,2737475);
        System.out.println(lst);
        System.out.println(lstCpy);
    }
}
