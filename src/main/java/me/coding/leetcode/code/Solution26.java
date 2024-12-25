package me.coding.leetcode.code;

class Solution26 {
    public String getHint(String secret, String guess) {
        int size = secret.length();
        int[] secretMap = new int[10];
        int[] guessMap = new int[10];
        int x = 0, y = 0;
        for (int i = 0; i < size; i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                secretMap[secret.charAt(i) - 48]++;
                guessMap[guess.charAt(i) - 48]++;
            } else {
                x++;
            }
        }
        for(int i = 0 ; i < 10 ; i++){
            y+=Math.min(secretMap[i],guessMap[i]);
        }
        return x+"A"+y+"B";
    }
}
