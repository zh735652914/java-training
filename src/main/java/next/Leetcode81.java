package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/2/1 11:34
 */
public class Leetcode81 {
    @Test
    public void test() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pos = left + (right - left) / 2;
            if (nums[pos] == target) {
                return true;
            }
            // 无法判断左右哪边有序
            if (nums[left] == nums[pos] && nums[right] == nums[pos]) {
                left++;
                right--;
            } else if (nums[left] <= nums[pos]) {
                if (target < nums[pos] && target >= nums[left]) {
                    right = pos - 1;
                } else {
                    left = pos + 1;
                }
            } else {
                if (target > nums[pos] && target <= nums[right]) {
                    left = pos + 1;
                } else {
                    right = pos - 1;
                }
            }
        }
        return false;
    }
}
