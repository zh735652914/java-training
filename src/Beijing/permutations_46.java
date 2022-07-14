package Beijing;
/*
https://leetcode.cn/problems/permutations/
 */

import java.util.ArrayList;
import java.util.List;

// 写了很多遍了，但是写起来有时候还是会心虚
public class permutations_46 {
    static class Solution {
        private List<List<Integer>> ans;
        private boolean[] visited;

        public List<List<Integer>> permute(int[] nums) {
            ans = new ArrayList<>();
            visited = new boolean[nums.length];
            backtrack(nums, new ArrayList<>());
            return ans;
        }

        private void backtrack(int[] nums, List<Integer> aPer) {
            if (aPer.size() == nums.length) {
                ans.add(new ArrayList<>(aPer));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                aPer.add(nums[i]);
                backtrack(nums, aPer);
                aPer.remove(aPer.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().permute(nums));
    }
}
