package beijing.hot100;
/*
https://leetcode.cn/problems/generate-parentheses/
 */

import java.util.LinkedList;
import java.util.List;

// 最后的去重很重要！！！第三遍写了，自己还是不会
public class generateParentheses_22 {
    static class Solution {
        private List<String> ans;

        public List<String> generateParenthesis(int n) {
            ans = new LinkedList<>();
            dfs(n, new StringBuilder(), 0, 0);
            return ans;
        }

        private void dfs(int n, StringBuilder aParentheses, int left, int right) {
            if (left > n || right > n) {
                return;
            }
            if (left == n && right == n) {
                ans.add(aParentheses.toString());
                return;
            }
            if (left >= right) {    //  left >= right是为了去重
                StringBuilder next = new StringBuilder(aParentheses);
                dfs(n, aParentheses.append('('), left + 1, right);
                dfs(n, next.append(')'), left, right + 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().generateParenthesis(n));
    }
}
