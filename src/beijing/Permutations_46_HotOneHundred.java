package beijing;
/*
https://leetcode.cn/problems/permutations/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/5/16 12:56
 */
// 不会写了
public class Permutations_46_HotOneHundred {
    static class Solution {
        private List<List<Integer>> ans;
        private boolean[] visited;

        public List<List<Integer>> permute(int[] nums) {
            ans = new ArrayList<>();
            visited = new boolean[nums.length];
            backtrack(nums, new ArrayList<>());
            return ans;
        }

        private void backtrack(int[] nums, List<Integer> per) {
            if (per.size() == nums.length) {
                ans.add(new ArrayList<>(per));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                per.add(nums[i]);
                visited[i] = true;
                backtrack(nums, per);
                per.remove(per.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().permute(nums));
    }
}
