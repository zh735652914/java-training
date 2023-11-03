package nowcoder;
/*
 牛客题霸-名企高频面试题
字符串的排列 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：722770
本题知识点： 字符串 动态规划
 算法知识视频讲解
题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
    static public class Solution {
        ArrayList<String> ans;
        boolean[] visited;

        public ArrayList<String> Permutation(String str) {
            ans = new ArrayList<>();
            if (str.length() == 0) {
                return ans;
            }
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            visited = new boolean[arr.length];
            dfs(arr, "");
            return ans;
        }

        private void dfs(char[] arr, String cur) {
            if (cur.length() == arr.length) {
                ans.add(cur);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder(cur);
            for (int i = 0; i < arr.length; i++) {
                if (visited[i] || i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
                    continue;
                }
                stringBuilder.append(arr[i]);
                visited[i] = true;
                dfs(arr, stringBuilder.toString());
                visited[i] = false;
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().Permutation(scanner.nextLine()));
        }
    }
}
