package beijing;
/*
https://leetcode-cn.com/problems/rotate-array/
 */

public class rotateArray {
    // 自己还是要加油
    static class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            int[] tmp = new int[k];
            System.arraycopy(nums, nums.length - k + 0, tmp, 0, k);
            for (int i = nums.length - k - 1; i >= 0; i--) {
                nums[i + k] = nums[i];
            }
            System.arraycopy(tmp, 0, nums, 0, k);
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
