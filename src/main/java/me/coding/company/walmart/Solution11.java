package me.coding.company.walmart;

import java.util.Arrays;

class Solution11 {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                deleteAllOccr(primes, n, i);
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) count++;
        }
        return count;
    }

    private void deleteAllOccr(boolean[] primes, long size, int i) {
        for (long j = i * i; j < size; j += i) {
            if (j < i && j != i ) primes[(int) j] = false;
        }
    }
}