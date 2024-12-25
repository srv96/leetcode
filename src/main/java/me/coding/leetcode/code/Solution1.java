package me.coding.leetcode.code;

class Solution1 {
    public boolean checkSign(int num1, int num2) {
        if ((num1 >= 0 && num2 >= 0) || (num1 < 0 && num2 < 0) || (num2==0)) {
            return true;
        } else {
            return false;
        }
    }
    public int reverse(int x) {
        int x1 = x;
        int rev = 0;
        while(x!=0){
            rev = (rev*10)+x%10;
            if(!checkSign(x1,rev))return 0;
            x/=10;
        }
        return rev;
    }
}
