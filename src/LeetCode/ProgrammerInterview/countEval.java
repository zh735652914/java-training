package LeetCode.ProgrammerInterview;
/*
面试题 08.14. 布尔运算
给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。
实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。

示例 1:

输入: s = "1^0|0|1", result = 0

输出: 2
解释: 两种可能的括号方法是
1^(0|(0|1))
1^((0|0)|1)
示例 2:

输入: s = "0&0&0&1^1|0", result = 1

输出: 10
提示：

运算符的数量不超过 19 个
通过次数1,289提交次数2,593
 */

import java.util.Arrays;

//不会写。。。看了别人的答案简直牛逼。。。
public class countEval {
    static class Solution {
        private int[][][] dp;
        private char[] arr;

        public int countEval(String s, int result) {
            dp = new int[s.length()][s.length()][2];
            arr = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }
            return eval(0, s.length() - 1, result);
        }

        private int eval(int start, int end, int result) {
            if (start == end) {
                return arr[start] - '0' == result ? 1 : 0;
            }
            if (dp[start][end][result] != -1) {
                return dp[start][end][result];
            }
            int ans = 0;
            for (int k = start; k < end; k += 2) {
                for (int left = 0; left < 2; left++) {
                    for (int right = 0; right < 2; right++) {
                        if (getBoolAns(left, right, arr[k + 1]) == result) {
                            ans += eval(start, k, left) * eval(k + 2, end, right);
                        }
                    }
                }
            }
            dp[start][end][result] = ans;
            return ans;
        }

        private int getBoolAns(int a, int b, char opt) {
            switch (opt) {
                case '&':
                    return a & b;
                case '|':
                    return a | b;
                case '^':
                    return a ^ b;
            }
            return a & b;
        }
    }

    public static void main(String[] args) {
        String s = "0&0&0&1^1|0";
        int result = 1;
        System.out.println(new Solution().countEval(s, result));
    }
}
