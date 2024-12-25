package me.coding.company.walmart;

import java.math.BigInteger;

class Solution15 {
    public int valueAfterKSeconds(int n, int k) {
        BigInteger result = nCr(n + k - 1, k);
        result = result.mod(new BigInteger("1000000007"));
        return Integer.parseInt(result.toString());
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static BigInteger nCr(int n, int r) {
        if (r > n) return BigInteger.ZERO;
        if (r == 0 || r == n) return BigInteger.ONE;
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }
}
