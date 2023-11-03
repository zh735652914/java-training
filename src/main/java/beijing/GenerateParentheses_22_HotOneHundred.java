package beijing;
/*
https://leetcode.cn/problems/generate-parentheses/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/4/16 19:27
 */
public class GenerateParentheses_22_HotOneHundred {
    // 自己还是不会，但是有点思路了
    static class Solution {
        private List<String> ans;

        public List<String> generateParenthesis(int n) {
            ans = new ArrayList<>();
            backtrack(new StringBuilder(), 0, 0, n);
            return ans;
        }

        private void backtrack(StringBuilder aParenthesis, int left, int right, int n) {
            if (left == right && left == n) {
                ans.add(aParenthesis.toString());
                return;
            }
            if (left < n) {
                backtrack(new StringBuilder(aParenthesis).append("("), left + 1, right, n);
            }
            if (left > right) {
                backtrack(new StringBuilder(aParenthesis).append(")"), left, right + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().generateParenthesis(n));
    }
}
