package leetcode;
/*
217. Contains Duplicate
Easy

559

613

Add to List

Share
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */

import java.util.Arrays;

class ContainsDuplicateSolution {
    //超时了。。。。
//    public boolean containsDuplicate0(int[] nums) {
//        List<Integer> H = new ArrayList<>(nums.length);
//        for (int x : nums) {
//            if (H.contains(x)) return true;
//            H.add(x);
//        }
//        return false;
//    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        Arrays.sort(nums);
        int last = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[last] == nums[i]) return true;
            last = i;
        }
        return false;
    }

}

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {2, 14, 18, 22, 22};
        System.out.println(new ContainsDuplicateSolution().containsDuplicate(nums));
    }
}
