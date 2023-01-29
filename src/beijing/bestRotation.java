package beijing;
/*
https://leetcode-cn.com/problems/smallest-rotation-with-highest-score/
 */

public class bestRotation {
    static class Solution {
        // 这题是真的难
        public int bestRotation(int[] nums) {
            int[] myK = new int[nums.length];// 不得分的个数
            int ans = 0, n = nums.length;
            for (int i = 0; i < nums.length; i++) {
                myK[(i - nums[i] + 1 + n) % n] += 1;// 这个递推公式对本题来说很重要
            }
            for (int i = 1; i < nums.length; i++) {
                myK[i] += myK[i - 1] - 1;
                if (myK[i] < myK[ans]) {
                    ans = i;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 0};
        System.out.println(new Solution().bestRotation(nums));
    }
}
