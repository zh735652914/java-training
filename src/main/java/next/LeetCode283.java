package next;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/4/9 08:17
 * https://leetcode.cn/problems/move-zeroes/
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int pos = 0;
        while (pos < nums.length) {
            if (nums[pos] != 0) {
                nums[index++] = nums[pos];
            }
            pos++;
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        assertEquals(Arrays.toString(nums), "[1, 3, 12, 0, 0]");
    }
}
