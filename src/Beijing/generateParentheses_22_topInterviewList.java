package Beijing;
/*
https://leetcode.cn/problems/generate-parentheses/
 */

import java.util.ArrayList;
import java.util.List;

// 都不是自己写的，四次了还是不会写
public class generateParentheses_22_topInterviewList {
    static class Solution {
        private List<String> ans;

        public List<String> generateParenthesis(int n) {
            ans = new ArrayList<>();
            backtrack(n, n, new StringBuilder());
            return ans;
        }

        private void backtrack(int left, int right, StringBuilder aPar) {
            if (left == 0 && right == 0) {
                ans.add(aPar.toString());
                return;
            }
            if (left > 0) {
                backtrack(left - 1, right, new StringBuilder(aPar).append('('));
            }
            if (right > left) {
                backtrack(left, right - 1, new StringBuilder(aPar).append(')'));
            }
        }
    }

    static class Solution0 {
        private List<String> ans;

        public List<String> generateParenthesis(int n) {
            ans = new ArrayList<>();
            backtrack(n, new StringBuilder(), 0, 0);
            return ans;
        }

        private void backtrack(int n, StringBuilder aPar, int left, int right) {
            if (left > n || right > n) {
                return;
            }
            if (left == right && left == n) {
                ans.add(aPar.toString());
            }
            if (left >= right) {
                StringBuilder next = new StringBuilder(aPar);
                backtrack(n, aPar.append('('), left + 1, right);
                backtrack(n, next.append(')'), left, right + 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().generateParenthesis(n));
    }
}
