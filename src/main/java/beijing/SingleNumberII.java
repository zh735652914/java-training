package beijing;
/*
https://leetcode-cn.com/problems/single-number-ii/
 */

public class SingleNumberII {
    // 这个方法很重要，相当于bit数组
    static class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                int count = 0;
                for (int num : nums) {
                    count += ((num >> i) & 1);
                }
                if (count % 3 != 0) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(new Solution().singleNumber(nums));
    }
}
