package Beijing;
/*
https://leetcode.cn/problems/validate-stack-sequences/
 */

import java.util.Stack;

// 自己没写出来
public class validateStackSequences {
    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            for (int num : pushed) {
                stack.push(num);
                while (!stack.isEmpty() && stack.peek() == popped[index]) {
                    stack.pop();
                    index++;
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5}, popped = {4, 5, 3, 2, 1};
        System.out.println(new Solution().validateStackSequences(pushed, popped));
    }
}
