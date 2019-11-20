package LeetCode;
/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Trie {
    /**
     * Initialize your data structure here.
     */
    private List<String> data;

    public Trie() {
        this.data = new ArrayList<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (!data.contains(word)) {
            data.add(word);
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return data.contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).length() >= prefix.length() && data.get(i).substring(0, prefix.length()).equals(prefix)) {
                return true;
            }
        }
        return false;
    }
}

public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
