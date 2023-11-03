package leetcode;
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        bracktrack(ans, new ArrayList<Integer>(), nums, 0);
        return ans;
    }

    private void bracktrack(List<List<Integer>> ans, List<Integer> aAns, int[] nums, int start) {
//        if (!ans.contains(aAns)) {
//            ans.add(new ArrayList<>(aAns));
//        }
        ans.add(new ArrayList<>(aAns));
        for (int i = start; i < nums.length; i++) {
//            int flag = 0;
//            if (!aAns.contains(nums[i])) {
//                aAns.add(nums[i]);
//                flag = 1;
//            }
            aAns.add(nums[i]);
            bracktrack(ans, aAns, nums, i + 1);
            aAns.remove(aAns.size() - 1);
//            if (flag == 1) {
//                aAns.remove(aAns.size() - 1);
//            }
        }
    }
}

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        SubsetsSolution SubSet = new SubsetsSolution();
        List<List<Integer>> ans = SubSet.subsets(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
