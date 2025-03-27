package next;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/27 08:13
 * https://leetcode.cn/problems/single-number/description/
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {4, 1, 2, 1, 2};
        assertEquals(4, singleNumber(nums));
    }
}
