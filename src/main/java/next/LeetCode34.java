package next;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2025/3/13 08:34
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int left = findPos(nums, target);
        int right = findPos(nums, target + 1);
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right - 1};
    }

    /**
     * 找出第一个大于等于target的数
     *
     * @param nums
     * @param target
     * @return
     */
    private int findPos(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
