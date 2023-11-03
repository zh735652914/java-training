package beijing;
/*
https://leetcode-cn.com/problems/generate-parentheses/
 */

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backtrack(ans, n, new StringBuilder(), 0, 0);
            return ans;
        }

        private void backtrack(List<String> ans, int n, StringBuilder stringBuilder, int left, int right) {
            if (left > n || right > n) {
                return;
            }
            if (left == right && left == n) {
                ans.add(stringBuilder.toString());
            }
            if (left >= right) {
                StringBuilder next = new StringBuilder(stringBuilder);  // 这个位置不能变
                backtrack(ans, n, stringBuilder.append('('), left + 1, right);
                backtrack(ans, n, next.append(')'), left, right + 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().generateParenthesis(n));
    }
}
