package Beijing;
/*
https://leetcode-cn.com/problems/permutations/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permute {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            Arrays.fill(visited, false);
            backtrack(nums, ans, new ArrayList<>(), visited);
            return ans;
        }

        private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> tmp, boolean[] visited) {
            if (tmp.size() == nums.length) {
                ans.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                tmp.add(nums[i]);
                visited[i] = true;
                backtrack(nums, ans, tmp, visited);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().permute(nums));
    }
}
