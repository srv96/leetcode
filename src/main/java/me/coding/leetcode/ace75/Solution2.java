package me.coding.leetcode.ace75;

class Solution2 {
    public boolean isVowel(char ch) {
        return (ch =='a' || ch=='i' || ch =='e' || ch == 'o' || ch == 'u')? true : false;
    }
    public int maxVowels(String s, int k) {
        int size = s.length();
        int maxCount = 0;
        int count = 0 ;
        for(int i = 0 ; i < k ; i++){
            if(isVowel(s.charAt(i)))count++;
            maxCount = count;
        }
        for(int i = 0 ; i < size-k;i++){
            if(isVowel(s.charAt(i))&&isVowel(s.charAt(i+k)))continue;
            else if (!isVowel(s.charAt(i))&&isVowel(s.charAt(i+k))) {
                count++;
                maxCount = Math.max(maxCount,count);
            } else if (isVowel(s.charAt(i))&&!isVowel(s.charAt(i+k))) {
                count--;
            }
        }
        return maxCount;
    }
}
