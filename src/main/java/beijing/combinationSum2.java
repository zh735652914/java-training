package beijing;
/*
https://leetcode-cn.com/problems/combination-sum-ii/
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class combinationSum2 {
    // 看了评论才会写的，去重比较麻烦
    static class Solution {
        private List<List<Integer>> ans;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            ans = new LinkedList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, 0, new LinkedList<>());
            return ans;
        }

        private void dfs(int[] candidates, int target, int index, List<Integer> combination) {
            if (target == 0) {
                ans.add(new LinkedList<>(combination));
                return;
            }
            if (index >= candidates.length || target < candidates[index]) {
                return;
            }
            int candidate = candidates[index];
            combination.add(candidate);
            dfs(candidates, target - candidate, index + 1, combination);
            combination.remove(combination.size() - 1);
            while (index < candidates.length && candidates[index] == candidate) {
                index++;
            }
            dfs(candidates, target, index, combination);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        System.out.println(new Solution().combinationSum2(candidates, target));
    }
}
