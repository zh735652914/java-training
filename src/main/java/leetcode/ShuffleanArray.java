package leetcode;
/*
384. Shuffle an Array
Medium

400

867

Add to List

Share
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 */

import java.util.Random;

//这题有点意思，不过自己不会写。。。
public class ShuffleanArray {
    static class Solution {
        private final int[] nums;
//        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
//            random = new Random();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            if (nums == null) return nums;
            Random random = new Random();
            int[] next = nums.clone();
            //注意如果从i=0开始的，random.nextInt(0 + 1);的结果永远是0；
            for (int i = 1; i < next.length; i++) {
                int x = random.nextInt(i + 1);
                swap(x, i, next);
            }
            return next;
        }

        private void swap(int x, int y, int[] nums) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution obj = new Solution(nums);
        int[] reset = obj.reset();
        int[] shuffle = obj.shuffle();
        System.out.println("reset is ");
        for (int value : reset) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("shuffle is ");
        for (int value : shuffle) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("reset is ");
        for (int value : reset) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("shuffle is ");
        for (int value : shuffle) {
            System.out.print(value + " ");
        }
    }
}
