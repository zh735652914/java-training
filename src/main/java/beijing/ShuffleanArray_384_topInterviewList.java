package beijing;
/*
https://leetcode.cn/problems/shuffle-an-array/
 */

import java.util.Random;

/**
 * @author zhouhao
 * @date 2023/2/16 13:02
 */
// 自己太菜了
public class ShuffleanArray_384_topInterviewList {
    static class Solution {
        private final int[] original;
        private final int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
            original = new int[nums.length];
            System.arraycopy(nums, 0, original, 0, nums.length);
        }

        public int[] reset() {
            return original;
        }

        public int[] shuffle() {
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int nextIndex = random.nextInt(nums.length - i) + i;
                int tmp = nums[nextIndex];
                nums[nextIndex] = nums[i];
                nums[i] = tmp;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        outputArray(solution.shuffle());    // Shuffle the array [1,2,3] and return its result.
        // Any permutation of [1,2,3] must be equally likely to be returned.
        // Example: return [3, 1, 2]
        outputArray(solution.reset());      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
        outputArray(solution.shuffle());    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
    }

    static private void outputArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
}
