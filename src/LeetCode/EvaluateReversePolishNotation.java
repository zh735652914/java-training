package LeetCode;

import java.util.Stack;

/*
150. Evaluate Reverse Polish Notation
Medium

736

409

Add to List

Share
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result
and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
//这个很简单
class EvaluateReversePolishNotationSolution {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String tmp = tokens[i];
            if (tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(Operator(a, b, tmp));
            } else {
                stack.push(Integer.valueOf(tmp));
            }
        }
        return stack.peek();
    }

    private int Operator(int x, int y, String OP) {
        if (OP.equals("+")) return y + x;
        if (OP.equals("-")) return y - x;
        if (OP.equals("*")) return y * x;
        return y / x;
    }
}

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
//        String[] tokens = {"2", "1", "+", "3", "*"};
//        String[] tokens = {"4", "13", "5", "/", "+"};
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvaluateReversePolishNotationSolution().evalRPN(tokens));
    }
}
