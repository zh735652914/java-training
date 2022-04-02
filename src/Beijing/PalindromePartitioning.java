package Beijing;
/*
https://leetcode-cn.com/problems/palindrome-partitioning/
 */

import java.util.ArrayList;
import java.util.List;

// 不是自己写的，但是这个记忆搜索的确要看看
public class PalindromePartitioning {
    static class Solution {
        private List<List<String>> ans;
        private int[][] find;
        private int n;

        public List<List<String>> partition(String s) {
            ans = new ArrayList<>();
            n = s.length();
            find = new int[n][n];
            dfs(s, new ArrayList<>(), 0);
            return ans;
        }

        private void dfs(String s, List<String> aPalindrome, int start) {
            if (start >= n) {
                ans.add(new ArrayList<>(aPalindrome));
                return;
            }
            for (int right = start; right < n; right++) {
                if (isPalindrome(s, start, right) == 1) {
                    aPalindrome.add(s.substring(start, right + 1));
                    dfs(s, aPalindrome, right + 1);
                    aPalindrome.remove(aPalindrome.size() - 1);
                }
            }
        }

        private int isPalindrome(String s, int left, int right) {
            if (find[left][right] != 0) {
                return find[left][right];
            }
            if (left >= right) {
                find[left][right] = 1;
            } else if (s.charAt(left) == s.charAt(right)) {
                find[left][right] = isPalindrome(s, left + 1, right - 1);
            } else {
                find[left][right] = -1;
            }
            return find[left][right];
        }
    }

    public static void main(String[] args) {
        String s = "cbbbcc";
        System.out.println(new Solution().partition(s));
    }
}
