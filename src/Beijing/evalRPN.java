package Beijing;
/*
https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */

import java.util.Stack;

public class evalRPN {
    // 自己写的效率不高啊
    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                if (isDigital(token)) {
                    stack.push(Integer.parseInt(token));
                } else {
                    if (stack.size() < 2) {
                        break;
                    } else {
                        int x = stack.pop();
                        int y = stack.pop();
                        switch (token) {
                            case "+":
                                stack.push(y + x);
                                break;
                            case "-":
                                stack.push(y - x);
                                break;
                            case "*":
                                stack.push(y * x);
                                break;
                            case "/":
                                stack.push(y / x);
                                break;
                        }
                    }
                }
            }
            return stack.pop();
        }

        private boolean isDigital(String x) {
            return !x.equals("+") && !x.equals("-") && !x.equals("*") && !x.equals("/");
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution().evalRPN(tokens));
    }
}
