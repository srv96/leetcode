package me.coding.sandbox;

import me.coding.ds.list.ListNode;

public class Solution6 {
    public ListNode sum(ListNode num1, ListNode num2) {
        ListNode curr1 = num1, curr2 = num2;
        int carry = 0;
        ListNode result = null, curr3 = null;
        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (curr3 == null) {
                curr3 = new ListNode(sum);
                result = curr3;
            } else {
                curr3.next = new ListNode(sum);
                curr3 = curr3.next;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        if (curr1 != null) {
            while (curr1 != null) {
                int sum = curr1.val + carry;
                carry = sum / 10;
                sum = sum % 10;

                if (curr3 == null) {
                    curr3 = new ListNode(sum);
                    result = curr3;
                } else {
                    curr3.next = new ListNode(sum);
                    curr3 = curr3.next;
                }
                curr1 = curr1.next;
            }
        }
        if (curr2 != null) {
            while (curr2 != null) {
                int sum = curr2.val + carry;
                carry = sum / 10;
                sum = sum % 10;

                if (curr3 == null) {
                    curr3 = new ListNode(sum);
                    result = curr3;
                } else {
                    curr3.next = new ListNode(sum);
                    curr3 = curr3.next;
                }
                curr2 = curr2.next;
            }
        }
        if (carry != 0) {
            if (curr3 == null) {
                curr3 = new ListNode(carry);
                result = curr3;
            } else {
                curr3.next = new ListNode(carry);
                curr3 = curr3.next;
            }
        }
        return result;
    }
}
