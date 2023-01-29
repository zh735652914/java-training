package beijing;
/*
https://leetcode-cn.com/problems/baseball-game/
 */

import java.util.Stack;

public class BaseballGame {
    static class Solution {
        public int calPoints(String[] ops) {
            Stack<Integer> stack = new Stack<>();
            for (String op : ops) {
                switch (op) {
                    case "C":
                        stack.pop();
                        break;
                    case "D":
                        stack.push(2 * stack.peek());
                        break;
                    case "+":
                        int x = stack.pop();
                        int y = stack.pop();
                        stack.push(y);
                        stack.push(x);
                        stack.push(x + y);
                        break;
                    default:
                        stack.push(Integer.parseInt(op));
                        break;
                }
            }
            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(new Solution().calPoints(ops));
    }
}
