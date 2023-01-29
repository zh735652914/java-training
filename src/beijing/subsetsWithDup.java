package beijing;
/*
https://leetcode-cn.com/problems/subsets-ii/
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class subsetsWithDup {
    // 这个写法很重要！
    static class Solution {
        private List<List<Integer>> ans;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            ans = new LinkedList<>();
            Arrays.sort(nums);
            dfs(nums, 0, new LinkedList<>());
            return ans;
        }

        private void dfs(int[] nums, int index, List<Integer> subset) {
            if (index >= nums.length) {
                ans.add(new LinkedList<>(subset));
                return;
            }
            subset.add(nums[index]);
            dfs(nums, index + 1, subset);
            subset.remove(subset.size() - 1);
            // 去重
            while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
                index++;
            }
            // 不选择当前结点
            dfs(nums, index + 1, subset);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new Solution().subsetsWithDup(nums));
    }
}
