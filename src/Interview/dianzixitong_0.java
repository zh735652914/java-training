package Interview;

public class dianzixitong_0 {
    static public class Solution {
        /**
         * 解码
         *
         * @param nums string字符串 数字串
         * @return int整型
         */
        public int solve(String nums) {
            if (nums.length() < 1) {
                return 0;
            }
            if (nums.charAt(0) == '0') {
                return 0;
            }
            int[] dp = new int[nums.length()];
            dp[0] = 1;
            for (int i = 1; i < nums.length(); i++) {
                if (nums.charAt(i) != '0') {
                    dp[i] = dp[i - 1];
                }
                int x = 10 * (nums.charAt(i - 1) - '0') + nums.charAt(i) - '0';
                if (x >= 10 && x <= 26) {
                    if (i == 1) {
                        dp[i]++;
                    } else {
                        dp[i] += dp[i - 2];
                    }
                }
            }
            return dp[nums.length() - 1];
        }
    }

    public static void main(String[] args) {
        String nums = "31717126241541717";
        System.out.println(new Solution().solve(nums));
    }
}
