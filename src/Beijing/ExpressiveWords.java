package Beijing;

public class ExpressiveWords {
    // 题目不难，就是要搞清楚题意
    static class Solution {
        public int expressiveWords(String s, String[] words) {
            int count = 0;
            for (String word : words) {
                if (canExpressive(s, word)) {
                    count++;
                }
            }
            return count;
        }

        private boolean canExpressive(String s, String word) {
            int p = 0, q = 0;
            int lenS = s.length(), lenW = word.length();
            while (p < lenS && q < lenW) {
                if (s.charAt(p) != word.charAt(q)) {
                    return false;
                }
                int count1 = 1;
                while (p + 1 < lenS && s.charAt(p) == s.charAt(p + 1)) {
                    p++;
                    count1++;
                }
                int count2 = 1;
                while (q + 1 < lenW && word.charAt(q) == word.charAt(q + 1)) {
                    q++;
                    count2++;
                }
                if (count1 < count2 || count1 != count2 && count1 < 3) {
                    return false;
                }
                p++;
                q++;
            }
            return p == s.length() && q == word.length();
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        String[] words = {"abcd"};
        System.out.println(new Solution().expressiveWords(s, words));
    }
}
