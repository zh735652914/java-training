package beijing.hot100;
/*
https://leetcode.cn/problems/decode-string/
 */

import java.util.Stack;

// 第二次，自己还是不会写
public class decodeString_394 {
    static class Solution {
        public String decodeString(String s) {
            Stack<StringBuilder> stack = new Stack<>();
            StringBuilder ans = new StringBuilder();
            Stack<Integer> nums = new Stack<>();
            int num = 0;
            for (char x : s.toCharArray()) {
                if (Character.isDigit(x)) {
                    num *= 10;
                    num += x - '0';
                } else if (x == '[') {
                    nums.push(num);
                    num = 0;
                    stack.push(ans);
                    ans = new StringBuilder();
                } else if (Character.isLetter(x)) {
                    ans.append(x);
                } else {
                    StringBuilder lastS = stack.pop();
                    int count = nums.pop();
                    while (count-- > 0) {
                        lastS.append(ans);
                    }
                    ans = lastS;
                }
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(new Solution().decodeString(s));
    }
}
