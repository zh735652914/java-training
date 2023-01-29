package beijing;
/*
https://leetcode.cn/problems/subsets/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets_78_topInterviewList {
    // 写了很多次了
    static class Solution {
        private List<List<Integer>> ans;
        private boolean[] visited;

        public List<List<Integer>> subsets(int[] nums) {
            ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            visited = new boolean[nums.length];
            Arrays.fill(visited, false);
            for (int i = 1; i <= nums.length; i++) {
                generateSubset(nums, i, new ArrayList<>(), 0);
            }
            return ans;
        }

        private void generateSubset(int[] nums, int len, List<Integer> subset, int index) {
            if (subset.size() == len) {
                ans.add(new ArrayList<>(subset));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                if (!visited[i]) {
                    subset.add(nums[i]);
                    visited[i] = true;
                    generateSubset(nums, len, subset, i + 1);
                    visited[i] = false;
                    subset.remove(subset.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().subsets(nums));
    }
}
