package Beijing;
/*
https://leetcode.cn/problems/valid-parentheses/
 */

import java.util.Stack;

public class validParentheses_20_topInterviewList {
    // 速度不快
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            int len = s.length();
            if ((len & 1) == 1) {
                return false;
            }
            for (int i = 0; i < len; i++) {
                if (isRight(s.charAt(i))) {
                    if (stack.isEmpty() || !isMatch(stack.peek(), s.charAt(i))) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            return stack.isEmpty();
        }

        private boolean isRight(char x) {
            return x == ')' || x == '}' || x == ']';
        }

        private boolean isMatch(char left, char right) {
            switch (right) {
                case ')':
                    return left == '(';
                case '}':
                    return left == '{';
                case ']':
                    return left == '[';
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "(){{[]{}";
        System.out.println(new Solution().isValid(s));
    }
}
