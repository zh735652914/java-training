package next;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/30 19:17
 * https://leetcode.cn/problems/majority-element/description/
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else {
                count--;
            }
            if (count <= 0) {
                major = nums[i];
                count++;
            }
        }
        return major;
    }

    @Test
    public void test() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        assertEquals(2, majorityElement(nums));
    }
}
