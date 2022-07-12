package Beijing;
/*
https://leetcode.cn/problems/valid-parentheses/
 */

import java.util.Stack;

// 速度没那么快，只是代码简洁一些
public class validParentheses_20 {
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if (!stack.isEmpty() && isMatch(stack.peek(), ch)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }

        private boolean isMatch(char left, char right) {
            switch (right) {
                case ')':
                    return left == '(';
                case ']':
                    return left == '[';
                case '}':
                    return left == '{';
                default:
                    return false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "()[]{()}";
        System.out.println(new Solution().isValid(s));
    }
}
