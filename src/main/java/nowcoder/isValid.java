package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：22164
本题知识点： 栈 字符串
 算法知识视频讲解
题目描述
给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
示例1
输入
复制
"["
输出
复制
false
示例2
输入
复制
"[]"
输出
复制
true
 */

import java.util.Stack;

public class isValid {
    static public class Solution {
        /**
         * @param s string字符串
         * @return bool布尔型
         */
        public boolean isValid(String s) {
            if (s.length() == 0) {
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty() && isMatch(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            return stack.isEmpty();
        }

        private boolean isMatch(char in, char out) {
            if (out == ']') {
                return in == '[';
            }
            if (out == ')') {
                return in == '(';
            }
            if (out == '}') {
                return in == '{';
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "[)]";
        System.out.println(new Solution().isValid(s));
    }
}
