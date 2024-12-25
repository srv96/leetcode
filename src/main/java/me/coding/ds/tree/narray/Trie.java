package me.coding.ds.tree.narray;

public class Trie {
    public Character character;
    public boolean isWord;
    public String word;
    public Trie[] children;

    public Trie(Character character, boolean isWord) {
        this.character = character;
        this.isWord = isWord;
        children = new Trie[26];
    }

    public void putString(String word) {
        char[] wordChar = word.toCharArray();
        int size = wordChar.length;
        put(this, wordChar, 0);
    }

    private void put(Trie trie, char[] wordChar, int idx) {
        Trie[] children = trie.children;
        this.isWord = this.isWord || idx == wordChar.length;
        if (this.isWord && this.word == null) this.word = new String(wordChar);
        if (idx < wordChar.length) {
            if (children[wordChar[idx] - 'a'] == null) {
                children[wordChar[idx] - 'a'] = new Trie(wordChar[idx], false);
            }
            children[wordChar[idx] - 'a'].put(children[wordChar[idx] - 'a'], wordChar, idx + 1);
        }
    }

    public boolean isWordPresent(String word) {
        char[] wordChar = word.toCharArray();
        return find(wordChar, 0);
    }

    private boolean find(char[] wordChar, int idx) {
        if (idx == wordChar.length) return this.isWord;
        else {
            if (this.children[wordChar[idx] - 'a'] == null) return false;
            else {
                return this.children[wordChar[idx] - 'a'].find(wordChar, idx + 1);
            }
        }
    }
}
