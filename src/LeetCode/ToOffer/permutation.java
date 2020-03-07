package LeetCode.ToOffer;
/*
面试题38. 字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。



你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。



示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]


限制：

1 <= s 的长度 <= 8

通过次数2,709提交次数5,039
 */

import java.util.*;

//自己没想到这样写
public class permutation {
    static class Solution {
        boolean[] visited;
        List<String> ans;

        public String[] permutation(String s) {
            visited = new boolean[s.length()];
            ans = new LinkedList<>();
            char[] ss = s.toCharArray();
            Arrays.sort(ss);
            dfs(ss, "");
            String[] fAns = new String[ans.size()];
            return ans.toArray(fAns);
        }

        private void dfs(char[] s, String res) {
            if (res.length() == s.length) ans.add(res);
            for (int i = 0; i < s.length; i++) {
                if (i > 0 && s[i] == s[i - 1] && !visited[i - 1] || visited[i]) continue;
                visited[i] = true;
                dfs(s, res + s[i]);
                visited[i] = false;
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
