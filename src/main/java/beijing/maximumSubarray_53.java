package beijing;

// 第三次了，自己还是不会写
public class maximumSubarray_53 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int ans = Integer.MIN_VALUE;
            int sum = 0;
            for (int num : nums) {
                sum = Math.max(sum + num, num);
                ans = Math.max(sum, ans);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}
