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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsIISolution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> Subset = new ArrayList<>();
        bracktrack(nums, Subset, 0);
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> aAns = ans.get(i);
            for (int j = 0; j < ans.size(); j++) {
                if (j == i) continue;
                if (ans.get(j).equals(aAns)) {
                    ans.remove(j);
                    j = 0;
                }
            }
        }
        return ans;
    }

    private void bracktrack(int[] nums, List<Integer> Subset, int index) {
//        System.out.println("ans=" + ans + "  Subset=" + Subset + "   index=" + ans.indexOf(Subset));
//        if (ans.indexOf(Subset) == -1) {
//            ans.add(Subset);
//            System.out.println("@@@@ ans=" + ans);
//        }
        ans.add(Subset);
        if (index == nums.length) return;
        for (int i = index; i < nums.length; i++) {
            Subset.add(nums[i]);
            bracktrack(nums, new ArrayList<>(Subset), i + 1);
//            System.out.println("Subset=" + Subset);
            Subset.remove(Subset.size() - 1);
        }
    }
}

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {};
//        int[] nums = {5, 5, 5, 5, 5};
        SubsetsIISolution SII = new SubsetsIISolution();
        List<List<Integer>> ans = SII.subsetsWithDup(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
