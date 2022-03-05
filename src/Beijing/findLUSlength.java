package Beijing;
/*
https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 */

public class findLUSlength {
    // 这题题目，说实话很迷
    static class Solution {
        public int findLUSlength(String a, String b) {
            return a.equals(b) ? -1 : Math.max(a.length(), b.length());
        }
    }

    public static void main(String[] args) {
        String a = "aba", b = "cdc";
        System.out.println(new Solution().findLUSlength(a, b));
    }
}
