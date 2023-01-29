package beijing;
/*
https://leetcode.cn/problems/permutations/
 */

import java.util.ArrayList;
import java.util.List;

public class permutations_46_topInterviewList {
    // 生疏了，不太会写了
    static class Solution {
        private List<List<Integer>> ans;
        private boolean[] visited;

        public List<List<Integer>> permute(int[] nums) {
            ans = new ArrayList<>();
            visited = new boolean[nums.length];
            backtrack(nums, new ArrayList<>());
            return ans;
        }

        private void backtrack(int[] nums, List<Integer> aPermute) {
            if (aPermute.size() == nums.length) {
                ans.add(new ArrayList<>(aPermute));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                aPermute.add(nums[i]);
                visited[i] = true;
                backtrack(nums, aPermute);
                aPermute.remove(aPermute.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().permute(nums));
    }
}
