package next;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/4/2 08:55
 * https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-i/description/?envType=daily-question&envId=2025-04-02
 */
public class LeetCode2873 {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        long dMax = 0;
        long iMax = 0;
        for (int k = 0; k < nums.length; k++) {
            ans = Math.max(ans, nums[k] * dMax);
            dMax = Math.max(dMax, iMax - nums[k]);
            iMax = Math.max(nums[k], iMax);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {12, 6, 1, 2, 7};
        assertEquals(77, maximumTripletValue(nums));
    }
}
