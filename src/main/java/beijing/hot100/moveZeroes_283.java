package beijing.hot100;
/*
https://leetcode.cn/problems/move-zeroes/
 */

public class moveZeroes_283 {
    // 这题的确是不难
    static class Solution {
        public void moveZeroes(int[] nums) {
            int last = 0, pos = 0;
            while (pos < nums.length) {
                if (nums[pos] != 0) {
                    nums[last++] = nums[pos];
                }
                pos++;
            }
            for (int i = last; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
