package leetcode;

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 */

import java.util.ArrayList;
import java.util.List;

class FindDisappearedNumbersSolution {
    // 自己写的，可以过，但是效率不够
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> ans = new ArrayList<>();
//        if (nums.length == 0) return ans;
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0 && nums[i] != 1) {
//                for (int j = 1; j < nums[i]; j++) {
//                    ans.add(j);
//                }
//                continue;
//            }
//            if (i == 0) continue;
//            if (nums[i] - nums[i - 1] > 1) {
//                for (int j = nums[i - 1] + 1; j < nums[i]; j++) {
//                    ans.add(j);
//                }
//            }
//        }
//        for (int i = nums[nums.length - 1] + 1; i <= nums.length; i++) {
//            ans.add(i);
//        }
//        return ans;
//    }

    //看了discuss后的解答，感觉自己是个智障。。。
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) ans.add(i + 1);
        }
        return ans;
    }
}

public class FindDisappearedNumbers {
    public static void main(String[] args) {
//        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums = {5, 4, 6, 7, 9, 3, 10, 9, 5, 6};
        FindDisappearedNumbersSolution findDisappearedNumbersSolution = new FindDisappearedNumbersSolution();
        System.out.println(findDisappearedNumbersSolution.findDisappearedNumbers(nums));
    }
}
