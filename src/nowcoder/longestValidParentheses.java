package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：20608
本题知识点： 字符串 动态规划
 算法知识视频讲解
题目描述
给出一个仅包含字符'('和')'的字符串，计算最长的格式正确的括号子串的长度。
对于字符串"(()"来说，最长的格式正确的子串是"()"，长度为2.
再举一个例子：对于字符串")()())",来说，最长的格式正确的子串是"()()"，长度为4.
示例1
输入
复制
"(()"
输出
复制
2
 */

import java.util.Stack;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：20608
本题知识点： 字符串 动态规划
 算法知识视频讲解
题目描述
给出一个仅包含字符'('和')'的字符串，计算最长的格式正确的括号子串的长度。
对于字符串"(()"来说，最长的格式正确的子串是"()"，长度为2.
再举一个例子：对于字符串")()())",来说，最长的格式正确的子串是"()()"，长度为4.
示例1
输入
复制
"(()"
输出
复制
2 */

public class longestValidParentheses {
    static public class Solution {
        /**
         * @param s string字符串
         * @return int整型
         */
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int maxLen = 0;
            int last = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    if (stack.isEmpty()) {
                        last = i;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            maxLen = Math.max(maxLen, i - last);
                        } else {
                            maxLen = Math.max(maxLen, i - stack.peek());
                        }
                    }
                }
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(new Solution().longestValidParentheses(s));
    }
}
