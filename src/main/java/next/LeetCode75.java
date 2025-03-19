package next;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2025/3/19 08:46
 * https://leetcode.cn/problems/sort-colors/
 */
public class LeetCode75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            // 这个顺序不能变，而且得循环
            while (i <= right && nums[i] == 2) {
                swap(nums, i, right);
                right--;
            }

            if (i >= left && nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    @Test
    public void test() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
