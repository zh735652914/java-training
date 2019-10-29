package LeetCode;
/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */

//自己写的很慢，这个是看了Discuss后的解答


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsIISolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> Subset = new ArrayList<>();
        bracktrack(ans, Subset, 0, nums);
        return ans;
    }

    private void bracktrack(List<List<Integer>> ans, List<Integer> Subset, int pos, int[] nums) {
        if (pos <= nums.length) {
            ans.add(Subset);
        }
        for (int i = pos; i < nums.length; ) {
            Subset.add(nums[i]);
            bracktrack(ans, new ArrayList<>(Subset), i + 1, nums);
            Subset.remove(Subset.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return;
    }
}

public class SubsetsII {
    public static void main(String[] args) {
//        int[] nums = {};
        int[] nums = {5, 5, 5, 5, 5};
        SubsetsIISolution SII = new SubsetsIISolution();
        List<List<Integer>> ans = SII.subsetsWithDup(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
