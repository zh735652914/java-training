package Beijing;
/*
https://leetcode.cn/problems/replace-words/
 */

import java.util.*;

// 自己写的前缀树
public class replaceWords {
    static class Solution {
        static class Node {
            boolean isEnd;
            char value;
            Map<Character, Node> child;

            Node(char value) {
                this.value = value;
                child = new HashMap<>();
                isEnd = false;
            }
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            String[] S = sentence.split(" ");
            Node root = new Node('#');
            for (String s : dictionary) {
                int len = s.length();
                Node cur = root;
                for (int i = 0; i < len; i++) {
                    char ch = s.charAt(i);
                    if (!cur.child.containsKey(ch)) {
                        cur.child.put(ch, new Node(ch));
                    }
                    cur = cur.child.get(ch);
                }
                cur.isEnd = true;
            }
            StringBuilder ans = new StringBuilder();
            for (String s : S) {
                int len = s.length();
                Node cur = root;
                int i = 0;
                for (i = 0; i < len; i++) {
                    char ch = s.charAt(i);
                    if (cur.child.containsKey(ch) && !cur.isEnd) {
                        cur = cur.child.get(ch);
                    } else {
                        break;
                    }
                }
                if (cur.isEnd) {
                    ans.append(s, 0, i);
                } else {
                    ans.append(s);
                }
                ans.append(' ');
            }
            return ans.substring(0, ans.length() - 1);
        }
    }

    public static void main(String[] args) {
        String[] D = {"cat", "bat", "rat"};
        List<String> dictionary = new ArrayList<>(Arrays.asList(D));
        String sentence = "the cattle was rattled by the battery";
        System.out.println(new Solution().replaceWords(dictionary, sentence));
    }
}
