package me.coding.company.microsoft;


class Solution17 {
    public void reverseWords(char[] s) {
        int l = 0, r = 0;
        int size = s.length;
        reverse(s, 0, s.length - 1);
        for (int i = 0; i < size; i++) {
            if (s[i] != ' ') {
                r++;
            } else {
                reverse(s, l, r - 1);
                r++;
                l = r;
            }
        }
        if (l != r) {
            reverse(s, l, r - 1);
            l = r;
        }
    }

    private void reverse(char[] s, int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        int idx = 0;
        for (int i = start; i <= mid; i++) {
            swap(s, i, end - idx);
            idx++;
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
