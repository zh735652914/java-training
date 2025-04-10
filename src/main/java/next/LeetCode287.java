package next;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/4/10 09:40
 */
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int faster = 0, slower = 0;
        while (true) {
            faster = nums[nums[faster]];
            slower = nums[slower];
            if (nums[faster] == nums[slower]) {
                break;
            }
        }
        slower = 0;
        while (slower != faster) {
            faster = nums[faster];
            slower = nums[slower];
        }
        return slower;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 4, 2, 2};
        assertEquals(2, findDuplicate(nums));
    }
}
