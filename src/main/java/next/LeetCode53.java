package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/16 08:52
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
