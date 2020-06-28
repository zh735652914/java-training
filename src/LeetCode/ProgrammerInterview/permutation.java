package LeetCode.ProgrammerInterview;
/*
面试题 08.07. 无重复字符串的排列组合
无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。

示例1:

 输入：S = "qwe"
 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
示例2:

 输入：S = "ab"
 输出：["ab", "ba"]
提示:

字符都是英文字母。
字符串长度在[1, 9]之间。
通过次数5,729提交次数7,055
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class permutation {
    static class Solution {
        public String[] permutation(String S) {
            List<String> list = new ArrayList<>();
            backtrack(list, S, "");
            String[] ans = new String[list.size()];
            list.toArray(ans);
            return ans;
        }

        private void backtrack(List<String> list, String s_res, String head) {
            StringBuilder builder = new StringBuilder(head);
            if (s_res == null || s_res.length() == 0) {
                list.add(builder.toString());
            }
            for (int i = 0; i < s_res.length(); i++) {
                builder.append(s_res.charAt(i));
                String next_res = s_res.substring(0, i) + s_res.substring(i + 1);
                backtrack(list, next_res, builder.toString());
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] ans = new Solution().permutation(scanner.nextLine());
            for (String x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
