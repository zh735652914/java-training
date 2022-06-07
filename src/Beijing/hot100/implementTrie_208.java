package Beijing.hot100;
/*
https://leetcode.cn/problems/implement-trie-prefix-tree/
 */

// 第二次写还是不会，官方的答案的确要好好学学
public class implementTrie_208 {
    static class Trie {
        boolean isEnd;
        Trie[] children;

        public Trie() {
            isEnd = false;
            children = new Trie[26];
        }

        public void insert(String word) {
            Trie cur = this;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                int pos = word.charAt(i) - 'a';
                if (cur.children[pos] == null) {
                    cur.children[pos] = new Trie();
                }
                cur = cur.children[pos];
            }
            cur.isEnd = true;
        }

        private Trie searcPrefix(String word) {
            Trie cur = this;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                int pos = word.charAt(i) - 'a';
                if (cur.children[pos] == null) {
                    return null;
                }
                cur = cur.children[pos];
            }
            return cur;
        }

        public boolean search(String word) {
            Trie node = searcPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searcPrefix(prefix) != null;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app"));       // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}
