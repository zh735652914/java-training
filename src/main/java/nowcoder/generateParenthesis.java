package nowcoder;
/*
 牛客题霸-名企高频面试题
括号生成 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：8074
本题知识点： 查找
 算法知识视频讲解
题目描述
给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
例如，给出n=3，解集为：
"((()))", "(()())", "(())()", "()()()", "()(())",
示例1
输入
复制
1
输出
复制
["()"]
示例2
输入
复制
2
输出
复制
["(())","()()"]
 */

import java.util.ArrayList;
import java.util.Scanner;

public class generateParenthesis {
    static public class Solution {
        /**
         * @param n int整型
         * @return string字符串ArrayList
         */
        ArrayList<String> ans;

        public ArrayList<String> generateParenthesis(int n) {
            ans = new ArrayList<>();
            backtrack(n, n, "");
            return ans;
        }

        private void backtrack(int left, int right, String list) {
            if (left > right) {
                return;
            }
            if (left == 0 && right == 0) {
                ans.add(list);
                return;
            }
            if (left > 0) {
                backtrack(left - 1, right, list + "(");
            }
            if (right > 0) {
                backtrack(left, right - 1, list + ")");
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
