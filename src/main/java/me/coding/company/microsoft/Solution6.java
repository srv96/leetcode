package me.coding.company.microsoft;

import java.util.Stack;

public class Solution6 extends Relation {
    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int candidate1 = stack.pop();
            int candidate2 = stack.pop();
            if (knows(candidate1, candidate2)) {
                stack.push(candidate2);
            } else {
                stack.push(candidate1);
            }
        }
        if (stack.empty())
            return -1;
        int finalCandidate = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i != finalCandidate && (!knows(i,finalCandidate) || knows(finalCandidate,i))) return -1;
        }
        return finalCandidate;
    }
}
