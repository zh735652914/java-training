package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
class ThreeSumSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
//        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1] ) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    List<Integer> aAns = new ArrayList<>();
                    aAns.add(nums[i]);
                    aAns.add(nums[l]);
                    aAns.add(nums[r]);
                    ans.add(aAns);
                    l++;
//                    break;
                }
            }
        }
        return ans;
    }
}

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSumSolution TS = new ThreeSumSolution();
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0, 0, 0};
        List<List<Integer>> ans = TS.threeSum(nums);
        System.out.println("ans=" + ans);

    }
}
