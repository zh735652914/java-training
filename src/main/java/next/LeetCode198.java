package next;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/30 20:58
 * https://leetcode.cn/problems/house-robber/
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        /*
        dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1])
         */
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[dp.length - 1];
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        assertEquals(4, rob(nums));
    }
}
