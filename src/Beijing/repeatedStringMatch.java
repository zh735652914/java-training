package Beijing;

/*
https://leetcode-cn.com/problems/repeated-string-match/
 */
public class repeatedStringMatch {
    static class Solution {
        public int repeatedStringMatch(String a, String b) {
            if (a.length() >= b.length()) {
                if (a.contains(b)) {
                    return 1;
                }
                String c = a + a;
                if (c.contains(b)) {
                    return 2;
                }
                return -1;
            }
            StringBuilder stringBuilder = new StringBuilder(a);
            int count = 1;
            while (stringBuilder.length() <= 2 * a.length() + b.length()) {
                if (stringBuilder.toString().contains(b)) {
                    return count;
                }
                stringBuilder.append(a);
                count++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String a = "abcbc", b = "cabcbca";
        System.out.println(new Solution().repeatedStringMatch(a, b));
    }
}
