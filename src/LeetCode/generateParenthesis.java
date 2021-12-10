package LeetCode;
/*
https://leetcode-cn.com/problems/generate-parentheses/
22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]


提示：

1 <= n <= 8
通过次数249,644提交次数324,181
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class generateParenthesis {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            generate(ans, n, new StringBuilder(), 0, 0);
            return ans;
        }

        private void generate(List<String> ans, int n, StringBuilder now, int L, int R) {
            if (L > n || R > n) {
                return;
            }
            if (L == R && L == n) {
                ans.add(now.toString());
            }
            // 下面这个很重要，需要去除不正确的结果
            if (L >= R) {
                StringBuilder next = new StringBuilder(now);
                generate(ans, n, now.append(')'), L, R + 1);
                generate(ans, n, next.append('('), L + 1, R);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().generateParenthesis(scanner.nextInt()));
        }
    }
}
