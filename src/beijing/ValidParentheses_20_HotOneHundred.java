package beijing;
/*
https://leetcode.cn/problems/valid-parentheses/
 */

import java.util.Stack;

/**
 * @author zhouhao
 * @date 2023/4/7 12:54
 */

// 的确很简单
public class ValidParentheses_20_HotOneHundred {
    static class Solution {
        public boolean isValid(String s) {
            if ((s.length() & 1) == 1) {
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char x = s.charAt(i);
                if (x == '(' || x == '[' || x == '{') {
                    stack.push(x);
                } else if (!stack.isEmpty() && isMatch(stack.peek(), x)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        }

        private boolean isMatch(char left, char right) {
            return left == '(' && right == ')' || left == '[' && right == ']' || left == '{' && right == '}';
        }
    }

    public static void main(String[] args) {
        String s = "()[]{}][";
        System.out.println(new Solution().isValid(s));
    }
}
