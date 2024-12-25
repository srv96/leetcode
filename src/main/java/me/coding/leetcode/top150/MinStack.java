package me.coding.leetcode.top150;

import java.util.Stack;

class MinStack {

    Stack<Long> stack;
    Long minVal;

    public MinStack() {
        stack = new Stack<>();
        minVal=Long.MAX_VALUE;
    }

    public void push(int val) {
        if(stack.isEmpty()){
            minVal= Long.valueOf(val);
            stack.push(Long.valueOf(val));
        }else if(val >= minVal){
            stack.push(Long.valueOf(val));
        }else{
            Long upVal = 2 * Long.valueOf(val) - minVal;
            minVal = Long.valueOf(val);
            stack.push(upVal);
        }
    }

    public void pop() {
        if(stack.isEmpty())return;

        if(stack.peek() < minVal){
            Long upVal = stack.peek();
            minVal = 2 * minVal - upVal;
            stack.pop();
        }else {
            stack.pop();
        }
    }

    public int top() {
        if(stack.peek() < minVal){
            return toIntBinary(minVal);
        }else{
            return toIntBinary(stack.peek());
        }
    }

    public int getMin() {
        return toIntBinary(minVal);
    }

    public int toIntBinary(Long value) {
        return value.intValue();
    }
}
