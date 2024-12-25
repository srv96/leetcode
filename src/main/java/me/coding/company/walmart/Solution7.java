package me.coding.company.walmart;

class Solution7 {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            if (sb.length() == 0) {
                break;
            }
            int idx = sb.indexOf(part);
            if (idx == -1) {
                break;
            } else {
                sb.replace(idx, idx + part.length(), "");
            }
        }
        return sb.toString();
    }
}
