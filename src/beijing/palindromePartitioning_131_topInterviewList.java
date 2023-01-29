package beijing;
/*
https://leetcode.cn/problems/palindrome-partitioning/
 */

import java.util.ArrayList;
import java.util.List;

public class palindromePartitioning_131_topInterviewList {
    // 自己不会写
    static class Solution {

        private boolean[][] dp;
        private List<List<String>> ans;

        public List<List<String>> partition(String s) {
            int len = s.length();
            dp = new boolean[len][len];
            ans = new ArrayList<>();
            for (int right = 0; right < len; right++) {
                for (int left = 0; left <= right; left++) {
                    if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                        dp[left][right] = true;
                    }
                }
            }
            dfs(s, 0, len, new ArrayList<>());
            return ans;
        }

        private void dfs(String s, int index, int len, List<String> aPalindrome) {
            if (index >= len) {
                ans.add(new ArrayList<>(aPalindrome));
                return;
            }
            for (int i = index; i < len; i++) {
                if (dp[index][i]) {
                    aPalindrome.add(s.substring(index, i + 1));
                    dfs(s, i + 1, len, aPalindrome);
                    aPalindrome.remove(aPalindrome.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Solution().partition(s));
    }
}
