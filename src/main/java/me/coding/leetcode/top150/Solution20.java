package me.coding.leetcode.top150;

class Solution20 {
    public double pow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;

        double temp = pow(x, n / 2);
        return n % 2 == 0 ? temp * temp : x * temp * temp;

    }

    public double myPow(double x, int n) {
        return (n < 0) ? pow(1 / x, Math.abs(n)) : pow(x, n);
    }
}
