package Beijing;
/*
https://leetcode.cn/problems/move-zeroes/
 */

public class moveZeroes {
    // 看了评论，我只想说：“我是傻逼”
    static class Solution0 {
        public void moveZeroes(int[] nums) {
            int end = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[end++] = nums[i];
                }
            }
            for (int i = end; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    // 官方的解析
    static class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0, right = 0;
            while (right < nums.length) {
                if (nums[right] != 0) {
                    int tmp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = tmp;
                    left++;
                }
                right++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12}; // 1,3,12,0,0
        new Solution().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
