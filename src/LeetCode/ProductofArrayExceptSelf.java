package LeetCode;

/*
Given an array nums of n integers where n > 1,  return an array output such that
 output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose
of space complexity analysis.)
 */
//好久没写题了，都不会写了。。。这是看了Discuss后才有的思路
class ProductofArrayExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0, tmp = 1; i < nums.length; i++) {
            ans[i] = tmp;
            tmp *= nums[i];
        }
        for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
            ans[i] *= tmp;
            tmp *= nums[i];
        }
        return ans;
    }
}

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {9, 0, -2};
        ProductofArrayExceptSelfSolution productofArrayExceptSelfSolution = new ProductofArrayExceptSelfSolution();
        int[] ans = productofArrayExceptSelfSolution.productExceptSelf(nums);
        for (int x :
                ans) {
            System.out.print(x + "  ");
        }
    }
}
