package Beijing;
/*
https://leetcode-cn.com/problems/combinations/
 */

import java.util.LinkedList;
import java.util.List;

// 中规中矩
public class Combinations {
    static class Solution {
        private List<List<Integer>> ans;

        public List<List<Integer>> combine(int n, int k) {
            ans = new LinkedList<>();
            dfs(new LinkedList<>(), 1, n, k);
            return ans;
        }

        private void dfs(List<Integer> combine, int x, int n, int k) {
            if (combine.size() == k) {
                ans.add(new LinkedList<>(combine));
            }
            for (int i = x; i <= n; i++) {
                combine.add(i);
                dfs(combine, i + 1, n, k);
                combine.remove(combine.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(new Solution().combine(n, k));
    }
}
