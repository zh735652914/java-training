package Beijing;
/*
https://leetcode-cn.com/problems/word-break/
 */

import java.util.*;

public class wordBreak {
    // 这个动态规划得看看
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int len = s.length(), MaxLen = 0;
            Set<String> set = new HashSet<>();
            for (String word : wordDict) {
                set.add(word);
                MaxLen = Math.max(MaxLen, word.length());
            }
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            for (int i = 1; i < len + 1; i++) {
                for (int j = i; j >= 0 && j >= (i - MaxLen); j--) {
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[len];
        }
    }


    // 自己写的，超时了
    static class Solution0 {
        private class Node {
            char value;
            boolean end;
            Map<Character, Node> next;

            Node(char value) {
                this.value = value;
                next = new HashMap<>();
                end = false;
            }
        }

        private Map<Character, Node> map;

        public boolean wordBreak(String s, List<String> wordDict) {
            map = new HashMap<>();
            for (String word : wordDict) {
                if (!map.containsKey(word.charAt(0))) {
                    Node Nnode = new Node(word.charAt(0));
                    map.put(word.charAt(0), Nnode);
                }
                Node node = map.get(word.charAt(0));
                for (int i = 1; i < word.length(); i++) {
                    if (!node.next.containsKey(word.charAt(i))) {
                        node.next.put(word.charAt(i), new Node(word.charAt(i)));
                    }
                    node = node.next.get(word.charAt(i));
                }
                node.end = true;
            }
            return valid(s, 0, true, null);
        }

        private boolean valid(String s, int index, boolean newWord, Node cur) {
            if (index >= s.length()) {
                return cur.end;
            }
            if (newWord) {
                if (!map.containsKey(s.charAt(index))) {
                    return false;
                }
                cur = map.get(s.charAt(index));
                if (cur.end) {
                    return valid(s, index + 1, false, cur) || valid(s, index + 1, true, cur);
                } else {
                    return valid(s, index + 1, false, cur);
                }
            } else {
                if (!cur.next.containsKey(s.charAt(index))) {
                    return false;
                }
                Node next = cur.next.get(s.charAt(index));
                if (next.end) {
                    return valid(s, index + 1, true, next) || valid(s, index + 1, newWord, next);
                } else {
                    return valid(s, index + 1, newWord, next);
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        String[] words = {"aaaa", "aa"};
        List<String> wordDict = new ArrayList<>(Arrays.asList(words));
        System.out.println(new Solution().wordBreak(s, wordDict));
    }
}
