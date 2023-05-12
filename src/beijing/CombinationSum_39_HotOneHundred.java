package beijing;
/*
https://leetcode.cn/problems/combination-sum/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/5/12 12:55
 */
public class CombinationSum_39_HotOneHundred {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Solution().combinationSum(candidates, target));
    }

    // 这种题目还是写少了
    static class Solution {
        private List<List<Integer>> ans;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ans = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(candidates, target, new ArrayList<>(), 0);
            return ans;
        }

        private void backtrack(int[] candidates, int target, List<Integer> aPair, int index) {
            if (target == 0) {
                ans.add(new ArrayList<>(aPair));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    return;
                }
                aPair.add(candidates[i]);
                backtrack(candidates, target - candidates[i], aPair, i);
                aPair.remove(aPair.size() - 1);
            }
        }
    }
}
