package beijing;
/*
https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */

// 官方写的，要好多了
public class Trie {
    private final Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        int len = word.length();
        Trie node = this;
        for (int i = 0; i < len; i++) {
            char x = word.charAt(i);
            int pos = x - 'a';
            if (node.children[pos] == null) {
                node.children[pos] = new Trie();
            }
            node = node.children[pos];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        int len = prefix.length();
        Trie node = this;
        for (int i = 0; i < len; i++) {
            int pos = prefix.charAt(i) - 'a';
            if (node.children[pos] == null) {
                return null;
            }
            node = node.children[pos];
        }
        return node;
    }

    public static void main(String[] args) {
        String[] ops = {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};
        String[][] S = {{}, {"apple"}, {"apple"}, {"app"}, {"app"}, {"app"}, {"app"}};
        Trie trie = new Trie();
        for (int i = 1; i < ops.length; i++) {
            switch (ops[i]) {
                case "insert":
                    trie.insert(S[i][0]);
                    System.out.println("null");
                    break;
                case "search":
                    System.out.println(trie.search(S[i][0]));
                    break;
                case "startsWith":
                    System.out.println(trie.startsWith(S[i][0]));
                    break;
            }
        }
    }
}

/*
// 自己写的可以运行，但是效率不太高，重点是写法不是预期
public class Trie {
    class Node {
        char value;
        Map<Character, Node> next;
        boolean end;

        Node(char x) {
            this.value = x;
            next = new HashMap<>(26);
            end = false;
        }

        public boolean addNext(Node node) {
            if (next.containsKey(node.value)) {
                return true;
            }
            next.put(node.value, node);
            return true;
        }
    }

    private Map<Character, Node> root;

    public Trie() {
        root = new HashMap<>(26);
    }

    public void insert(String word) {
        int len = word.length();
        if (!root.containsKey(word.charAt(0))) {
            root.put(word.charAt(0), new Node(word.charAt(0)));
        }
        Node pos = root.get(word.charAt(0));
        for (int i = 1; i < len; i++) {
            char x = word.charAt(i);
            if (!pos.next.containsKey(x)) {
                pos.next.put(x, new Node(x));
            }
            pos = pos.next.get(x);
        }
        pos.end = true;
    }

    public boolean search(String word) {
        int len = word.length();
        if (!root.containsKey(word.charAt(0))) {
            return false;
        }
        Node pos = root.get(word.charAt(0));
        for (int i = 1; i < len; i++) {
            char x = word.charAt(i);
            if (!pos.next.containsKey(x)) {
                return false;
            }
            pos = pos.next.get(x);
        }
        return pos.end;
    }

    public boolean startsWith(String prefix) {
        int len = prefix.length();
        if (!root.containsKey(prefix.charAt(0))) {
            return false;
        }
        Node pos = root.get(prefix.charAt(0));
        for (int i = 1; i < len; i++) {
            char x = prefix.charAt(i);
            if (!pos.next.containsKey(x)) {
                return false;
            }
            pos = pos.next.get(x);
        }
        return true;
    }

    public static void main(String[] args) {
        String[] ops = {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};
        String[][] S = {{}, {"apple"}, {"apple"}, {"app"}, {"app"}, {"app"}, {"app"}};
        Trie trie = new Trie();
        for (int i = 1; i < ops.length; i++) {
            switch (ops[i]) {
                case "insert":
                    trie.insert(S[i][0]);
                    System.out.println("null");
                    break;
                case "search":
                    System.out.println(trie.search(S[i][0]));
                    break;
                case "startsWith":
                    System.out.println(trie.startsWith(S[i][0]));
                    break;
            }
        }
    }
}
*/