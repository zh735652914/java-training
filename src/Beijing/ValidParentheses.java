package Beijing;

import java.util.Stack;

public class ValidParentheses {
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    stack.push(s.charAt(i));
                } else if (!stack.isEmpty() && isMatch(s.charAt(i), stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        }

        private boolean isMatch(char x, char y) {
            return x == ')' && y == '(' || x == ']' && y == '[' || x == '}' && y == '{';
        }
    }

    public static void main(String[] args) {
        String s = "()[()(())]{}";
        System.out.println(new Solution().isValid(s));
    }
}
