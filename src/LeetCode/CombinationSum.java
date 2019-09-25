package LeetCode;
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */


import java.util.ArrayList;
import java.util.List;

class CombinationSumSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> combination = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), candidates, target, 0, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> combination, int[] candidates, int target, int sum, int start) {
        if (sum > target) return;
        if (sum == target) {
//            ans.add(combination);
//            return;

            //下面这个地方很重要！！！！
            ans.add(new ArrayList<>(combination));
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
//            sum = sum + candidates[i];
            backtrack(ans, combination, candidates, target, sum + candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }
}

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSumSolution CSS = new CombinationSumSolution();
        System.out.println(CSS.combinationSum(candidates, target));
    }
}
