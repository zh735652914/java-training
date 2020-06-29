package LeetCode.ProgrammerInterview;
/*
面试题 08.09. 括号
括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。

说明：解集不能包含重复的子集。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
通过次数5,227提交次数6,486
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//自己没想到。。。
public class generateParenthesis {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            dfs(n, 0, 0, list, "");
            return list;
        }

        private void dfs(int n, int left, int right, List<String> list, String str) {
            if (left == n && left == right) {
                list.add(str);
                return;
            }
            if (left + 1 <= n) {
                dfs(n, left + 1, right, list, str + '(');
            }
            if (right + 1 <= left) {
                dfs(n, left, right + 1, list, str + ')');
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
