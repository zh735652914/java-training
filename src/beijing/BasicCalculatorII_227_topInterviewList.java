package beijing;
/*
https://leetcode.cn/problems/basic-calculator-ii/
 */

import java.util.Stack;

// 自己没写出来
public class BasicCalculatorII_227_topInterviewList {
    static class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int len = s.length();
            char lastOp = '+';
            int num = 0;
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    num *= 10;
                    num += ch - '0';
                }
                if (!Character.isDigit(ch) && ch != ' ' || i == len - 1) {
                    switch (lastOp) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                    }
                    lastOp = ch;
                    num = 0;
                }
            }
            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        System.out.println(new Solution().calculate(s));
    }
}
