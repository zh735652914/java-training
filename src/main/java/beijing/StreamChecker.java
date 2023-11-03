package beijing;
/*
https://leetcode.cn/problems/stream-of-characters/
 */

/**
 * @author zhouhao
 * @date 2023/3/24 12:59
 */
// 说实话，不太像是困难题
public class StreamChecker {
    private final StringBuilder word;
    private final Node root;

    public StreamChecker(String[] words) {
        root = new Node();
        word = new StringBuilder();
        for (String word : words) {
            Node cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Node();
                }
                cur = cur.next[c - 'a'];
            }
            cur.isEnd = true;
        }
    }

    public boolean query(char letter) {
        word.append(letter);
        Node node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
            if (node.isEnd) {
                return true;
            }
        }
        return false;
    }

    static class Node {
        Node[] next;
        boolean isEnd;

        public Node() {
            next = new Node[26];
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        System.out.println(streamChecker.query('a')); // 返回 False
        System.out.println(streamChecker.query('b')); // 返回 False
        System.out.println(streamChecker.query('c')); // 返回n False
        System.out.println(streamChecker.query('d')); // 返回 True ，因为 'cd' 在 words 中
        System.out.println(streamChecker.query('e')); // 返回 False
        System.out.println(streamChecker.query('f'));// 返回 True ，因为 'f' 在 words 中
        System.out.println(streamChecker.query('g')); // 返回 False
        System.out.println(streamChecker.query('h')); // 返回 False
        System.out.println(streamChecker.query('i')); // 返回 False
        System.out.println(streamChecker.query('j')); // 返回 False
        System.out.println(streamChecker.query('k')); // 返回 False
        System.out.println(streamChecker.query('l')); // 返回 True ，因为 'kl' 在 words 中
    }
}
