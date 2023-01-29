package beijing;
/*
https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/
 */

public class WordDictionary {
    private final Trip root;

    public WordDictionary() {
        root = new Trip();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trip root) {
        if (index == word.length()) {
            return root.isEnd;
        }
        char ch = word.charAt(index);
        if (ch != '.') {
            int childrenIndex = ch - 'a';
            if (root.children[childrenIndex] == null) {
                return false;
            }
            return dfs(word, index + 1, root.children[childrenIndex]);
        } else {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null && dfs(word, index + 1, root.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private class Trip {
        private final Trip[] children;
        private boolean isEnd;

        Trip() {
            children = new Trip[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trip node = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trip();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
    }

    public static void main(String[] args) {
        String[] ops = {"WordDictionary", "addWord", "addWord", "addWord", "search", "search", "search", "search"};
        String[][] words = {{}, {"bad"}, {"dad"}, {"mad"}, {"pad"}, {"bad"}, {".ad"}, {"b.."}};
        WordDictionary obj = new WordDictionary();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "WordDictionary":
                    continue;
                case "addWord":
                    obj.addWord(words[i][0]);
                    continue;
                case "search":
                    System.out.println(obj.search(words[i][0]));
            }
        }
    }
}
