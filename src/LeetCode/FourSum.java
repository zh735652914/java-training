package LeetCode;
/*
Given an array nums of n integers and an integer target,
are there elements a, b, c, and d in nums such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionFourSum {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;
        if (nums.length == 4) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum == target) {
                List<Integer> aAns = new ArrayList<>();
                aAns.add(nums[0]);
                aAns.add(nums[1]);
                aAns.add(nums[2]);
                aAns.add(nums[3]);
                ans.add(aAns);
            }
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            CThree(nums, sum, i);
        }
        return ans;
    }

    public void CThree(int[] nums, int sum, int pos) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> aAns=new ArrayList<>();
        for (int i = pos + 1; i < nums.length - 2; i++) {
            if ((i - 1) != pos && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if ((l - 1) != i && nums[l] == nums[l - 1]) l++;
                if (l >= r) break;
//                if (nums[r]==nums[r-1]) r--;
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp < sum) {
                    l++;
                } else if (tmp > sum) {
                    r--;
                } else {
                    List<Integer> aAns = new ArrayList<>();
                    aAns.add(nums[pos]);
                    aAns.add(nums[i]);
                    aAns.add(nums[l]);
                    aAns.add(nums[r]);
                    if (!ans.contains(aAns)) {
                        ans.add(aAns);
                    }
//                    ans.add(aAns);
                    l++;
                }
            }
        }
    }
}

public class FourSum {
    public static void main(String[] args) {
//        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int[] nums = {-1, 2, 2, -5, 0, -1, 4};
//        int[] nums = {-1, -5, -5, -3, 2, 5, 0, 4};
        int target = 3;
        SolutionFourSum FS = new SolutionFourSum();
        System.out.println("ans=" + FS.fourSum(nums, target));
    }
}
