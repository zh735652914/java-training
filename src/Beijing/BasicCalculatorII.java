package Beijing;
/*
https://leetcode-cn.com/problems/basic-calculator-ii/
 */

import java.util.Stack;

public class BasicCalculatorII {
    // 看了解析写的，写法上要好一点
    static class Solution {
        public int calculate(String s) {
            Stack<Integer> nums = new Stack<>();
            int num = 0;
            int n = s.length();
            char lastOp = '+';
            for (int i = 0; i < n; i++) {
                char x = s.charAt(i);
                if (x >= '0' && x <= '9') {
                    num = num * 10 + x - '0';
                }
                if (!Character.isDigit(x) && x != ' ' || i == n - 1) {
                    switch (lastOp) {
                        case '+':
                            nums.push(num);
                            break;
                        case '-':
                            nums.push(-num);
                            break;
                        case '*':
                            nums.push(nums.pop() * num);
                            break;
                        case '/':
                            nums.push(nums.pop() / num);
                            break;
                    }
                    num = 0;
                    lastOp = x;
                }
            }
            while (nums.size() > 1) {
                int b = nums.pop();
                int a = nums.pop();
                nums.push(a + b);
            }
            return nums.pop();
        }
    }

    // 自己写的效率不高
    static class Solution0 {
        public int calculate(String s) {
            Stack<Integer> nums = new Stack<>();
            Stack<Character> ops = new Stack<>();
            int n = s.length();
            boolean flag = false;
            boolean isPositive = true;
            for (int i = 0; i < n; i++) {
                char x = s.charAt(i);
                if (x == ' ' || x == '+') {
                    continue;
                }
                if (x == '*' || x == '/') {
                    flag = true;
                    ops.push(x);
                } else if (x == '-') {
                    isPositive = false;
                } else {
                    int j = i;
                    while (j < n && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                        j++;
                    }
                    int num = Integer.parseInt(s.substring(i, j));
                    nums.push(isPositive ? num : -num);
                    isPositive = true;
                    if (flag) {
                        int b = nums.pop();
                        int a = nums.pop();
                        int c = ops.pop() == '*' ? a * b : a / b;
                        nums.push(c);
                        flag = false;
                    }
                    i = j - 1;
                }
            }
            while (nums.size() > 1) {
                int b = nums.pop();
                int a = nums.pop();
                nums.push(a + b);
            }
            return nums.pop();
        }
    }

    public static void main(String[] args) {
        String s = "1*10+1";
        /*
        3,5,2
        +,/

        3+5/2
         */
        System.out.println(new Solution().calculate(s));
    }
}
