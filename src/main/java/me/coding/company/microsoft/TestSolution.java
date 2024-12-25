package me.coding.company.microsoft;


import me.coding.ds.list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        ListNode head = ListNode.fromArrayList(new ArrayList<>(Arrays.asList(0,3,1,0,4,5,2,0,1,0,3,0,2,2,0)));
        System.out.println(new Solution().mergeNodes(head));
    }
}
