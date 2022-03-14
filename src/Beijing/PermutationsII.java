package Beijing;
/*
https://leetcode-cn.com/problems/permutations-ii/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
    static class Solution {
        private List<List<Integer>> ans;
        private boolean[] visited;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            ans = new LinkedList<>();
            visited = new boolean[nums.length];
            dfs(nums, new ArrayList<>());
            return ans;
        }

        private void dfs(int[] nums, List<Integer> permutation) {
            if (permutation.size() == nums.length) {
                ans.add(new ArrayList<>(permutation));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                // 下面这个if是关键
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                    continue;
                }
                permutation.add(nums[i]);
                visited[i] = true;
                dfs(nums, permutation);
                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new Solution().permuteUnique(nums));
    }
}
