package LeetCode;
/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */


/*
这种递归很重要！！！！！！！！！！
 */

import java.util.ArrayList;
import java.util.List;

class PermutationsSolution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
//        Arrays.sort(nums);
        backtrack(nums, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> aAns) {
        if (aAns.size() == nums.length) {
            ans.add(new ArrayList<>(aAns));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (aAns.contains(nums[i])) continue;
                aAns.add(nums[i]);
                backtrack(nums, ans, aAns);
                aAns.remove(aAns.size() - 1);
            }
        }
    }
}

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        PermutationsSolution PS = new PermutationsSolution();
        System.out.println(PS.permute(nums));
    }
}
