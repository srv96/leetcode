package me.coding.company.google;

class Solution39 {
    public String countAndSay(int n) {
        int idx = 1;
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = RLE(result);
        }
        return result;
    }

    private String RLE(String result) {
        int len = result.length();
        String rle = "";
        int count = 1;
        int lIdx = 0;
        for (int i = 1; i < len; i++) {
            if (result.charAt(lIdx) == result.charAt(i)) {
                count++;
            } else {
                rle += String.valueOf(count);
                rle += String.valueOf(result.charAt(lIdx));
                lIdx = i;
                count = 1;
            }
        }
        rle += String.valueOf(count);
        rle += String.valueOf(result.charAt(lIdx));
        return rle;
    }
}
