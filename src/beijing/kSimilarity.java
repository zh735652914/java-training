package beijing;
/*
https://leetcode.cn/problems/k-similar-strings/submissions/
 */

public class kSimilarity {
    // 自己没写出来，看了解析才写的
    static class Solution {
        private int ans;
        private int len1;

        public int kSimilarity(String s1, String s2) {
            ans = Integer.MAX_VALUE;
            len1 = s1.length();
            dfs(s1, s2, 0, 0);
            return ans;
        }

        private void dfs(String s1, String s2, int index, int count) {
            if (index >= len1) {
                ans = Math.min(ans, count);
                return;
            }
            if (s1.charAt(index) != s2.charAt(index)) {
                for (int i = index + 1; i < len1; i++) {
                    if (s1.charAt(i) != s2.charAt(i) && s2.charAt(index) == s1.charAt(i)) {
                        s1 = swap(s1, i, index);
                        dfs(s1, s2, index + 1, count + 1);
                        s1 = swap(s1, i, index);
                    }
                }
            } else {
                dfs(s1, s2, index + 1, count);
            }
        }

        private String swap(String s, int x, int y) {
            char[] ch = s.toCharArray();
            char tmp = ch[x];
            ch[x] = ch[y];
            ch[y] = tmp;
            return new String(ch);
        }
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "ba";
        System.out.println(new Solution().kSimilarity(s1, s2));
    }
}
