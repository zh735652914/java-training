package beijing;
/*
https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */

import java.util.Stack;

public class evaluateReversePolishNotation_150_topInterviewList {
    // 这题的确不难
    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            int x, y;
            for (String token : tokens) {
                switch (token) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        y = stack.pop();
                        x = stack.pop();
                        stack.push(x - y);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        y = stack.pop();
                        x = stack.pop();
                        stack.push(x / y);
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution().evalRPN(tokens));
    }
}
