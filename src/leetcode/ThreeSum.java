package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
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
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            List<Integer> aAns = new LinkedList<>();
            aAns.add(nums[i]);
            int sum = 0 - nums[i], begin = i + 1, end = nums.length - 1;
            while (begin < end) {
                if (nums[begin] + nums[end] < sum) {
                    begin++;
                } else if (nums[begin] + nums[end] > sum) {
                    end--;
                } else {
                    aAns.add(nums[begin]);
                    aAns.add(nums[end]);
                    ans.add(new LinkedList<>(aAns));
                    aAns.remove(aAns.size() - 1);
                    aAns.remove(aAns.size() - 1);
                    while (begin < end && nums[begin + 1] == nums[begin]) begin++;
                    while (begin < end && nums[end - 1] == nums[end]) end--;
//                    System.out.println("begin=" + begin + "   end=" + end);
                    begin++;
                    end--;
                }
            }
        }
        return ans;
    }
}

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSumSolution TS = new ThreeSumSolution();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> ans = TS.threeSum(nums);
        System.out.println("ans=" + ans);
    }
}
