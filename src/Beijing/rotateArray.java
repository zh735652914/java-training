package Beijing;
/*
https://leetcode-cn.com/problems/rotate-array/
 */

public class rotateArray {
    // 自己还是要加油
    static class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            int[] tmp = new int[k];
            for (int i = 0; i < k; i++) {
                tmp[i] = nums[nums.length - k + i];
            }
            for (int i = nums.length - k - 1; i >= 0; i--) {
                nums[i + k] = nums[i];
            }
            for (int i = 0; i < k; i++) {
                nums[i] = tmp[i];
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 3;
        int[] nums = {-1};
        int k = 2;
        new Solution().rotate(nums, k);
        for (int x : nums) {
            System.out.print(x + ", ");
        }
    }
}
