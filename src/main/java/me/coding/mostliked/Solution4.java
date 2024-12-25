package me.coding.mostliked;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution4 {
    public List<String> generateParenthesis(int n) {
        Stack<Character> balanceStack = new Stack<>();
        List<String> result = new ArrayList<>();
        getParenthesis(new StringBuilder(),balanceStack,n,n,result);
        return result;
    }

    private void getParenthesis(StringBuilder str, Stack<Character> balanceStack, int left, int right, List<String> result) {
        if(left==0&&right==0){
            result.add(str.toString());
            return;
        }else{
            if(left>0){
                str.append('(');
                balanceStack.push('(');
                getParenthesis(str,balanceStack,left-1,right,result);
                str.deleteCharAt(str.length()-1);
                balanceStack.pop();
            }
            if(right>0&&!balanceStack.isEmpty()){
                str.append(')');
                balanceStack.pop();
                getParenthesis(str,balanceStack,left,right-1,result);
                str.deleteCharAt(str.length()-1);
                balanceStack.push('(');
            }
        }
    }
}