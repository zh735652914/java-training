package Beijing;
/*
https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 */

import java.util.Stack;

public class minAddToMakeValid {
    // 解析中的方法，自己需要看看
    static class Solution {
        public int minAddToMakeValid(String s) {
            int leftCount = 0;
            int ans = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '(') {
                    leftCount++;
                } else {
                    if (leftCount > 0) {
                        leftCount--;
                    } else {
                        ans++;
                    }
                }
            }
            return ans + leftCount;
        }
    }

    // 自己写的，效率太低了
    static class Solution0 {
        public int minAddToMakeValid(String s) {
            Stack<Character> stack = new Stack<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                while (!stack.isEmpty() && i < len && stack.peek() == '(' && s.charAt(i) == ')') {
                    i++;
                    stack.pop();
                }
                if (i >= len) {
                    break;
                }
                stack.push(s.charAt(i));
            }
            return stack.size();
        }
    }

    public static void main(String[] args) {
        String s = "((())";
        System.out.println(new Solution().minAddToMakeValid(s));
    }
}
