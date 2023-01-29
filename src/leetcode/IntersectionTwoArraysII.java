package leetcode;
/*
350. Intersection of Two Arrays II
Easy

972

326

Add to List

Share
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements
into the memory at once?
 */

import java.util.HashMap;
import java.util.Stack;

//自己写的，就是时间效率不高
class IntersectionTwoArraysIISolution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            int[] ans = {};
            return ans;
        }
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int x : nums1) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }
        Stack<Integer> stack = new Stack<>();
        for (int x : nums2) {
            if (map1.containsKey(x) && map1.get(x) >= 1) {
                stack.push(x);
            }
            map1.put(x, map1.getOrDefault(x, 0) - 1);
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; !stack.isEmpty(); i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}

public class IntersectionTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
//        int[] nums1 = {4, 9, 5};
//        int[] nums2 = {9, 4, 9, 8, 4};
        int[] ans = new IntersectionTwoArraysIISolution().intersect(nums1, nums2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
    }
}
