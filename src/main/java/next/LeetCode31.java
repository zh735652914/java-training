package next;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2025/3/10 08:42
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int left = nums.length - 2, right = nums.length - 1;
        while (left >= 0) {
            if (nums[left] < nums[right]) {
                int pos = nums.length - 1;
                while (pos >= right && nums[pos] <= nums[left]) {
                    pos--;
                }
                swap(nums, pos, left);
                break;
            }
            left--;
            right--;
        }
        reverse(nums, left + 1);
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
