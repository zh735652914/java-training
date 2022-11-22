package Beijing;
/*
https://leetcode.cn/problems/move-zeroes/
 */

public class MoveZeroes_283_topInterviewList {
    // 的确是简单题
    static class Solution {
        public void moveZeroes(int[] nums) {
            int pos = 0, index = 0;
            while (pos < nums.length) {
                if (nums[pos] != 0) {
                    nums[index++] = nums[pos];
                }
                pos++;
            }
            while (index < nums.length) {
                nums[index++] = 0;
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
