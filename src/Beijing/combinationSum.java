package Beijing;
/*
https://leetcode-cn.com/problems/combination-sum/
 */

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    static class Solution {
        private List<List<Integer>> ans;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ans = new ArrayList<>();
            search(candidates, target, new ArrayList<>(), 0);
            return ans;
        }

        private void search(int[] candidates, int target, List<Integer> aAns, int index) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<>(aAns));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                aAns.add(candidates[i]);
                search(candidates, target - candidates[i], aAns, i);
                aAns.remove(aAns.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Solution().combinationSum(candidates, target));
    }
}
