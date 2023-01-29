package beijing.hot100;
/*
https://leetcode.cn/problems/combination-sum/
 */

import java.util.ArrayList;
import java.util.List;

public class combinationSum_39 {
    // 第二次写居然不会了
    static class Solution {
        private List<List<Integer>> ans;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ans = new ArrayList<>();
            findCombination(candidates, target, new ArrayList<>(), 0);
            return ans;
        }

        private void findCombination(int[] candidates, int target, List<Integer> combination, int index) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<>(combination));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                combination.add(candidates[i]);
                findCombination(candidates, target - candidates[i], combination, i);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Solution().combinationSum(candidates, target));
    }
}