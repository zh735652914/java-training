package Beijing;
/*
https://leetcode-cn.com/problems/subsets/
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class subsets {
    // 这个写法得看看
    static class Solution {
        private List<List<Integer>> ans;

        public List<List<Integer>> subsets(int[] nums) {
            ans = new LinkedList<>();
            dfs(nums, new LinkedList<>(), 0);
            return ans;
        }

        private void dfs(int[] nums, List<Integer> subset, int index) {
            if (index == nums.length) {
                ans.add(new LinkedList<>(subset));
                return;
            }
            subset.add(nums[index]);
            dfs(nums, subset, index + 1);
            subset.remove(subset.size() - 1);
            dfs(nums, subset, index + 1);
        }
    }

    // 不是写的不太好，是我看错题目了
    static class Solution0 {
        private List<List<Integer>> ans;

        public List<List<Integer>> subsets(int[] nums) {
            ans = new LinkedList<>();
            Arrays.sort(nums);
            List<Integer> subset = new LinkedList<>();
            ans.add(new LinkedList<>());
            for (int i = 1; i <= nums.length; i++) {
                dfs(nums, subset, i, 0);
            }
            return ans;
        }

        private void dfs(int[] nums, List<Integer> subset, int k, int start) {
            if (subset.size() == k) {
                ans.add(new LinkedList<>(subset));
                return;
            }
            if (start >= nums.length) {
                return;
            }
            for (int i = start; i < nums.length; i++) {
                subset.add(nums[i]);
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
                dfs(nums, subset, k, i + 1);
                subset.remove(subset.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().subsets(nums));
    }
}
