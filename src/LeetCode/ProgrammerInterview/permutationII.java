package LeetCode.ProgrammerInterview;
/*
面试题 08.08. 有重复字符串的排列组合
有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。

示例1:

 输入：S = "qqe"
 输出：["eqq","qeq","qqe"]
示例2:

 输入：S = "ab"
 输出：["ab", "ba"]
提示:

字符都是英文字母。
字符串长度在[1, 9]之间。
通过次数4,169提交次数5,937
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class permutationII {

    static class Solution2 {
        public String[] permutation(String S) {
            List<String> res = new ArrayList<>();
            int len = S.length();
            if (len == 0) return new String[0];
            boolean[] used = new boolean[len];
            char[] sChar = S.toCharArray();

            StringBuilder path = new StringBuilder(len);

            // 排序是为了后面的剪枝
            Arrays.sort(sChar);

            dfs(res, sChar, len, path, 0, used);
            return res.toArray(new String[0]);
        }

        /**
         * @param res   结果集
         * @param sChar 输入字符数组
         * @param len   字符数组长度
         * @param path  根结点到任意结点的路径
         * @param depth 当前树的深度
         * @param used  使用标记数组
         */
        private void dfs(List<String> res
                , char[] sChar
                , int len
                , StringBuilder path
                , int depth
                , boolean[] used) {
            // 到达叶子结点
            if (depth == len) {
                res.add(path.toString());
                return;
            }

            for (int i = 0; i < len; i++) {
                if (!used[i]) {

                    // 根据已排序字符数组, 剪枝
                    if (i > 0 && sChar[i] == sChar[i - 1] && !used[i - 1]) {
                        continue;
                    }

                    path.append(sChar[i]);
                    used[i] = true; // 标记选择
                    dfs(res, sChar, len, path, depth + 1, used);
                    path.deleteCharAt(depth);
                    used[i] = false; // 撤销选择
                }
            }
        }
    }


    //自己写的效率太低
    static class Solution {
        public String[] permutation(String S) {
            List<String> list = new ArrayList<>();
            backtrack(list, "", S);
            String[] ans = new String[list.size()];
            list.toArray(ans);
            return ans;
        }

        private void backtrack(List<String> list, String head, String res) {
            StringBuilder builder = new StringBuilder(head);
            if (res == null || res.length() == 0) {
                if (!list.contains(builder.toString())) {
                    list.add(builder.toString());
                }
                return;
            }
            for (int i = 0; i < res.length(); i++) {
                builder.append(res.charAt(i));
                String next_res = res.substring(0, i) + res.substring(i + 1);
                backtrack(list, builder.toString(), next_res);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] ans = new Solution().permutation(scanner.nextLine());
            for (String x : ans) {
                System.out.print(x + ",");
            }
            System.out.println();
        }
    }
}
