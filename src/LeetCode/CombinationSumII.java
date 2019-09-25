package LeetCode;
/*
Given a collection of candidate numbers (candidates) and a target number (target),
 find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */
/*
没自己写出来！！！
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumIISolution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> aAns = new ArrayList<>();
        backtrack(candidates, aAns, target, 0, 0);
        return ans;
    }

    private void backtrack(int[] candidates, List<Integer> aAns, int target, int start, int sum) {
        if (sum == target && !ans.contains(aAns)) ans.add(new ArrayList<>(aAns));
        if (sum < target) {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i - 1] == candidates[i]) continue;
                aAns.add(candidates[i]);
                backtrack(candidates, aAns, target, i + 1, sum + candidates[i]);
                aAns.remove(aAns.size() - 1);
            }
        }
    }

//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        List<List<Integer>> combinations = new ArrayList<>();
//        backtrack(combinations, new ArrayList<>(), candidates, target, 0, 0);
//        return combinations;
//    }
//
//    private void backtrack(List<List<Integer>> combinations, List<Integer> combination, int[] candidates, int target, int start, int sum) {
//        if (sum == target)
//            combinations.add(new ArrayList<>(combination));
//        else if (sum < target)
//            for (int i = start; i < candidates.length; i++) {
//                if (i > start && candidates[i - 1] == candidates[i])
//                    continue;
//                combination.add(candidates[i]);
//                backtrack(combinations, combination, candidates, target, i + 1, sum + candidates[i]);
//                combination.remove(combination.size() - 1);
//            }
//    }
}

public class CombinationSumII {
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSumIISolution CSIIS = new CombinationSumIISolution();
        System.out.println(CSIIS.combinationSum2(nums, target));
    }
}
