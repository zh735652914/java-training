package beijing;
/*
https://leetcode.cn/problems/implement-trie-prefix-tree/
 */

import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree_208_topInterviewList {
    // 自己写的效率不高
    static class Trie {
        static class Node {
            char val;
            Map<Character, Node> next;
            boolean end;

            Node(char val) {
                this.val = val;
                next = new HashMap<>();
                end = false;
            }
        }

        private final Node root;

        public Trie() {
            root = new Node('0');
        }

        public void insert(String word) {
            int len = word.length();
            Node cur = root;
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                if (!cur.next.containsKey(ch)) {
                    cur.next.put(ch, new Node(ch));
                }
                cur = cur.next.get(ch);
            }
            cur.end = true;
        }

        public boolean search(String word) {
            int len = word.length();
            Node cur = root;
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                if (!cur.next.containsKey(ch)) {
                    return false;
                }
                cur = cur.next.get(ch);
            }
            return cur.end;
        }

        public boolean startsWith(String prefix) {
            int len = prefix.length();
            Node cur = root;
            for (int i = 0; i < len; i++) {
                char ch = prefix.charAt(i);
                if (!cur.next.containsKey(ch)) {
                    return false;
                }
                cur = cur.next.get(ch);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}
