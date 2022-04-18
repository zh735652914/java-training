package Beijing;
/*
https://leetcode-cn.com/problems/combination-sum-iii/
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    // 自己参考别人的后自己写的，去重的重点是：每个combination里面的数字都是从大到小的
    static class Solution {
        private List<List<Integer>> ans;

        public List<List<Integer>> combinationSum3(int k, int n) {
            ans = new ArrayList<>();
            dfs(k, n, new ArrayList<>(), 1);
            return ans;
        }

        private void dfs(int k, int n, List<Integer> combination, int start) {
            if (combination.size() == k && n == 0) {
                ans.add(new ArrayList<>(combination));
                return;
            }
            if (combination.size() > k || n < 0) {
                return;
            }
            for (int i = start; i <= 9; i++) {
                combination.add(i);
                dfs(k, n - i, combination, i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }

    // 这是官方的写法
    static class Solution1 {
        private List<List<Integer>> ans;
        private List<Integer> combination;

        public List<List<Integer>> combinationSum3(int k, int n) {
            ans = new ArrayList<>();
            combination = new ArrayList<>();
            dfs(1, k, n);
            return ans;
        }

        private void dfs(int cur, int k, int n) {
            if (combination.size() > k || combination.size() + (9 - cur + 1) < k) {
                return;
            }
            if (combination.size() == k) {
                int sum = 0;
                for (int x : combination) {
                    sum += x;
                }
                if (sum == n) {
                    ans.add(new ArrayList<>(combination));
                    return;
                }
            }
            combination.add(cur);
            dfs(cur + 1, k, n);
            combination.remove(combination.size() - 1);
            dfs(cur + 1, k, n);
        }
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        System.out.println(new Solution().combinationSum3(k, n));
    }
}
