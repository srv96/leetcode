package me.coding.company.google;

class Trie {
    char ch;
    boolean word;
    Trie[] children;

    public Trie() {
        word = false;
        children = new Trie[26];
    }

    public void insert(String word) {
        if (word.equals("")) this.word = true;
        else {
            children[word.charAt(0) - 'a'] = children[word.charAt(0) - 'a'] == null ? new Trie() : children[word.charAt(0) - 'a'];
            children[word.charAt(0) - 'a'].ch = word.charAt(0);
            children[word.charAt(0) - 'a'].insert(word.substring(1));
        }
    }

    public boolean search(String word) {
        if (word.equals("")) return this.word;
        else {
            return children[word.charAt(0) - 'a'] != null ? children[word.charAt(0) - 'a'].search(word.substring(1)) : false;
        }
    }

    public boolean startsWith(String prefix) {
        if (prefix.equals("")) return true;
        else {
            return children[prefix.charAt(0) - 'a'] != null ? children[prefix.charAt(0) - 'a'].startsWith(prefix.substring(1)) : false;
        }
    }
}