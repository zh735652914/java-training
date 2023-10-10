package beijing;
/*
https://sleetcode.cn/problems/movement-of-robots/?envType=daily-question&envId=2023-10-10
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/10/10 12:14
 */
public class SumDistance {
    // 这题需要注意数值过大的情况
    static class Solution {

        private static final int M = 1000000007;

        public int sumDistance(int[] nums, String s, int d) {
            long[] newPos = new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (s.charAt(i) == 'L') {
                    newPos[i] = (long) nums[i] - d;
                } else {
                    newPos[i] = (long) nums[i] + d;
                }
            }
            long ans = 0;
            Arrays.sort(newPos);
            for (int i = 1; i < newPos.length; i++) {
                ans += (newPos[i] - newPos[i - 1]) * i % M * (newPos.length - i) % M;
                ans %= M;
            }
            return (int) ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 2};
        String s = "RLL";
        int d = 3;
        System.out.println(new Solution().sumDistance(nums, s, d));
    }
}
