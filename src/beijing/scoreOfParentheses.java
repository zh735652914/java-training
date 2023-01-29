package beijing;
/*
https://leetcode.cn/problems/score-of-parentheses/
 */


import java.util.Stack;

public class scoreOfParentheses {

    // 自己不会写
    static class Solution {
        public int scoreOfParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '(') {
                    stack.push(0);
                }
                if (s.charAt(i) == ')') {
                    int v = stack.pop();
                    int score = Math.max(2 * v, 1) + stack.pop();
                    stack.push(score);
                }
            }
            return stack.pop();
        }
    }

    // 不是自己写的，自己不会
    static class Solution1 {
        public int scoreOfParentheses(String s) {
            int len = s.length(), ans = 0;
            int deep = 0;
            for (int i = 0; i < len; i++) {
                deep += s.charAt(i) == '(' ? 1 : -1;
                if (i >= 1 && s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                    ans += 1 << deep;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(new Solution().scoreOfParentheses(s));
    }
}
