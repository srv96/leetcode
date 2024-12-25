package me.coding.company.google;

import me.coding.ds.list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSolution {
    public static void main(String[] args) {
        ListNode head = ListNode.fromArrayList(new ArrayList<>(Arrays.asList(1,2,3,4,5,13,6,7,8,9)));
        head = new Solution().removeNodes(head);
        System.out.println(head);
    }

}