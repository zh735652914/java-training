package leetcode;
/*
227. Basic Calculator II
Medium

1025

180

Add to List

Share
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 */

import java.util.Stack;

//自己写的太辣鸡
//class BasicCalculatorIISolution {
//    public int calculate(String s) {
//        Stack<Integer> num = new Stack<>();
//        Stack<Character> op = new Stack<>();
//        StringBuilder tmp;
//        boolean flag = false;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ' ') continue;
//            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
//                op.push(s.charAt(i));
//                if (op.peek() == '*' || op.peek() == '/') {
//                    flag = true;
//                }
//                continue;
//            }
//            tmp = new StringBuilder();
//            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//                tmp.append(s.charAt(i));
//                i++;
//            }
//            i--;
//            if (op.isEmpty() || op.peek() == '+') {
//                num.push(Integer.valueOf(tmp.toString()));
//                if (!op.isEmpty()) op.pop();
//                continue;
//            }
////            if (op.isEmpty()) continue;
//            if (flag) {
//                int y = Integer.parseInt(tmp.toString());
//                int x = num.pop();
//                char opera = op.pop();
//                num.push(CALCU(x, y, opera));
//                flag = false;
//            } else {
//                char oper = op.pop();
//                if (oper == '-') {
//                    num.push(-Integer.parseInt(tmp.toString()));
//                } else {
//                    num.push(Integer.parseInt(tmp.toString()));
//                }
//            }
//        }
//        while (num.size() > 1) {
//            int y = num.pop();
//            int x = num.pop();
////            char opera = op.pop();
////            num.push(CALCU(x, y, opera));
//            num.push(x + y);
//        }
//        return num.pop();
//    }
//
//
//    private int CALCU(int x, int y, char op) {
//        if (op == '+') {
//            return x + y;
//        } else if (op == '-') {
//            return x - y;
//        } else if (op == '*') {
//            return x * y;
//        } else {
//            return x / y;
//        }
//    }
//}
class BasicCalculatorIISolution {
    //别人写的代码。。整洁
    public int calculate(String s) {
        Stack<Integer> num = new Stack<>();
        int x = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                x = x * 10 + (s.charAt(i) - '0');
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (op == '+') {
                    num.push(x);
                } else if (op == '-') {
                    num.push(-x);
                } else if (op == '*') {
                    num.push(num.pop() * x);
                } else if (op == '/') {
                    num.push(num.pop() / x);
                }
                op = s.charAt(i);
                x = 0;
            }
        }
        while (!num.isEmpty()) {
            x += num.pop();
        }
        return x;
    }
}

public class BasicCalculatorII {
    public static void main(String[] args) {
//        String s = "3+2*2";
        String s = "3+5 / 2";
//        String s = "-1-1+1";
        System.out.println(new BasicCalculatorIISolution().calculate(s));
    }
}
