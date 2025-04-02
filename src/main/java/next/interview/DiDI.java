package next.interview;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/4/2 15:32
 */
public class DiDI {
    /**
     * 一个发生了旋转的有序数组，如[3,4,5,7,0,1,2]，查找是否存在目标值，如存在，返回下标，如不存在，返回-1
     */
    public int func(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] < nums[mid]) {
                // 左边有序
                if (target < nums[mid] && nums[left] <= target) {
                    // 在有序中
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边有序
                if (target > nums[mid] && nums[right] >= target) {
                    // 在有序中
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {3, 4, 5, 7, 0, 1, 2};
        int target = 5;
        assertEquals(2, func(nums, target));
    }

    @Test
    public void test2() {
        int[] nums = {3, 4, 5, 7, 0, 1, 2};
        int target = 10;
        assertEquals(-1, func(nums, target));
    }

    @Test
    public void test3() {
        int[] nums = {3, 4, 5, 7, 0, 1, 2, 2, 2, 2, 2, 2, 2};
        int target = 0;
        assertEquals(4, func(nums, target));
    }
}
