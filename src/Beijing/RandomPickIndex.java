package Beijing;
/*
https://leetcode-cn.com/problems/random-pick-index/
 */

import java.util.Random;

// 这个算法自己不会，需要看看
public class RandomPickIndex {
    static class Solution {
        private final int[] nums;
        private final Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int pick(int target) {
            int count = 0;
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    count++;
                    if (random.nextInt(count) == 0) {
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        Solution obj = new Solution(nums);
        String[] ops = {"pick", "pick", "pick"};
        int[] Nums = {3, 1, 3};
        for (int i = 0; i < ops.length; i++) {
            if ("pick".equals(ops[i])) {
                System.out.println(obj.pick(Nums[i]));
            }
        }
    }
}
