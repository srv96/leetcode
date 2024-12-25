package me.coding.company.visa;

class Solution4 {
    public String breakPalindrome(String palindrome) {
        StringBuilder stringBuilder = new StringBuilder(palindrome);
        int size = palindrome.length();
        boolean changed = false;
        int mid = size % 2 == 0 ? (int)(size / 2) + 1 : size / 2;
        if(size == 2)mid = 1;
        for (int i = 0; i < size; i++) {
            if (i != mid && stringBuilder.charAt(i) != 'a') {
                stringBuilder.setCharAt(i, 'a');
                changed = true;
                break;
            }
        }
        if (stringBuilder.length() > 1 && !changed) {
            stringBuilder.setCharAt(stringBuilder.length() - 1, 'b');
            changed = true;
        }
        return changed ? stringBuilder.toString() : "";
    }
}