package beijing;
/*
https://leetcode.cn/problems/shuffle-an-array/
 */

import java.util.Random;

// 又不会写，我发现只要是随机概率的题，我都不会
public class shuffleanArray {
    static class Solution {
        private final int[] original;
        private final int[] nums;

        public Solution(int[] nums) {
            original = new int[nums.length];
            System.arraycopy(nums, 0, original, 0, nums.length);
            this.nums = nums;
        }

        public int[] reset() {
            System.arraycopy(original, 0, nums, 0, nums.length);
            return nums;
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
        int[] nums = {1, 2, 3};
        Solution obj = new Solution(nums);
        String[] ops = {"shuffle", "reset", "shuffle"};
        for (String op : ops) {
            if (op.equals("shuffle")) {
                output(obj.shuffle());
            } else {
                output(obj.reset());
            }
        }
    }

    static void output(int[] nums) {
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
