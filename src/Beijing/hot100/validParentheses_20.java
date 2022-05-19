package Beijing.hot100;
/*
https://leetcode.cn/problems/valid-parentheses/
 */

import java.util.Stack;

// 细心就行
public class validParentheses_20 {
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            int len = s.length();
            if ((len & 1) == 1) {
                return false;
            }
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if (isLeft(ch)) {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty() || !isMatch(stack.pop(), ch)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        private boolean isMatch(char x, char y) {
            return x == '[' && y == ']' || x == '{' && y == '}' || x == '(' && y == ')';
        }

        private boolean isLeft(char x) {
            return x == '[' || x == '{' || x == '(';
        }
    }

    public static void main(String[] args) {
        String s = "()[]{}][";
        System.out.println(new Solution().isValid(s));
    }
}
