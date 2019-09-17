package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
class PermutationsIISolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), new ArrayList<>(), nums);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> aAns, List<Integer> index, int[] nums) {
        if (aAns.size() == nums.length && !ans.contains(aAns)) {
            ans.add(new ArrayList<>(aAns));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (index.contains(i)) continue;
                aAns.add(nums[i]);
                index.add(i);
                backtrack(ans, aAns, index, nums);
                aAns.remove(aAns.size() - 1);
                index.remove(index.size() - 1);
            }
        }
    }
}

public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        PermutationsIISolution PIIS = new PermutationsIISolution();
        System.out.println(PIIS.permuteUnique(nums));
    }
}
