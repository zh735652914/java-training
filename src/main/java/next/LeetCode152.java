package next;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/30 15:46
 * https://leetcode.cn/problems/maximum-product-subarray/description/
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        long lastMax = nums[0];
        long lastMin = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long max = lastMax, min = lastMin;
            lastMax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            lastMin = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            ans = (int) Math.max(lastMax, ans);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, -2, 4};
        assertEquals(6, maxProduct(nums));
    }
}
