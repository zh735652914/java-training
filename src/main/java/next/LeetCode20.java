package next;

import org.junit.Test;

import java.util.Stack;

/**
 * @author zhouhao
 * @date 2025/3/8 10:19
 * https://leetcode.cn/problems/valid-parentheses/
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        if (s.length() == 1 || (s.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && isMatch(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char left, char right) {
        return left == '(' && right == ')' || left == '[' && right == ']' || left == '{' && right == '}';
    }

    @Test
    public void test() {
        String s = "()[]{})(";
        System.out.println(isValid(s));
    }
}
