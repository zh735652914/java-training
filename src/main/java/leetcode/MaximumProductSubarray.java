package leetcode;
/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

//自己不会写。。。看了discuss，发现自己是个智障。。。

class MaximumProductSubarraySolution {
    //有问题
//    public int maxProduct(int[] nums) {
//        int ans = nums[0], product = ans, sub = nums[0], submax = sub;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i - 1] == 0) {
//                product = 0;
//                sub = nums[i];
//            }
//            if (nums[i] < 0) {
//                submax = Math.max(sub, submax);
//                product *= nums[i];
//                if (nums[i - 1] < 0) {
//                    sub = nums[i] * nums[i - 1];
////                    submax = Math.max(submax, sub);
//                }
//            } else if (nums[i] == 0) {
//                sub = 0;
//                submax = Math.max(sub, submax);
//                product = Math.max(submax, product);
//            } else {
//                if (nums[i - 1] < 0) {
//                    if (sub < 0) {
//                        sub = nums[i];
//                    } else {
//                        sub *= nums[i];
//                    }
//                } else {
//                    if (nums[i - 1] > 0) {
//                        sub *= nums[i];
//                    }
//                }
//                submax = Math.max(sub, submax);
//                product *= nums[i];
//            }
//            ans = Math.max(ans, Math.max(product, submax));
//        }
//        return ans;
//    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * tmp, nums[i] * min), nums[i]);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
//        int[] nums = {2, 3, -2, 4, 5, -1, 6, 0, 1, 2};
//        int[] nums = {-2, 0, -1};
//        int[] nums = {0, 2};
//        int[] nums = {2, -5, -2, -4, -1, 3};
        MaximumProductSubarraySolution maximumProductSubarraySolution = new MaximumProductSubarraySolution();
        System.out.println(maximumProductSubarraySolution.maxProduct(nums));
    }
}
