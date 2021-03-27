package LeetCode;

import java.util.Scanner;
import java.util.Stack;

/*
https://leetcode-cn.com/problems/valid-parentheses/
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。


示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true


提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
通过次数577,490提交次数1,316,163
 */
public class isValid {
    static class Solution0 {
        public boolean isValid(String s) {
            if (s.length() % 2 == 1) {
                return false;
            }
            if (s.length() == 0) {
                return true;
            }
            Stack<Character> Lstack = new Stack<>();
            Stack<Character> Rstack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                Lstack.push(s.charAt(i));
            }
            while (!Lstack.isEmpty()) {
                if (Rstack.isEmpty() || !isMatch(Lstack.peek(), Rstack.peek())) {
                    Rstack.push(Lstack.pop());
                } else {
                    Lstack.pop();
                    Rstack.pop();
                }
            }
            return Rstack.isEmpty();
        }

        private boolean isMatch(char L, char R) {
            if (L == '(') {
                return R == ')';
            } else if (L == '{') {
                return R == '}';
            } else if (L == '[') {
                return R == ']';
            } else {
                return false;
            }
        }
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(')');
                } else if (s.charAt(i) == '[') {
                    stack.push(']');
                } else if (s.charAt(i) == '{') {
                    stack.push('}');
                } else if (stack.isEmpty() || s.charAt(i) != stack.pop()) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        while (scanner.hasNext()) {
            System.out.println(solution.isValid(scanner.nextLine()));
        }
    }
}
