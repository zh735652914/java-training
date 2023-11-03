package beijing;

/**
 * @author zhouhao
 * @date 2023/4/24 21:02
 */

// 自己还是不会写
public class NextPermutation_31_HotOneHundred {
    static class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length < 2) {
                return;
            }
            int left = nums.length - 2, right = nums.length - 1;
            while (left >= 0) {
                if (nums[left] < nums[right]) {
                    int pos = nums.length - 1;
                    while (pos >= right) {
                        if (nums[pos] > nums[left]) {
                            break;
                        }
                        pos--;
                    }
                    swap(nums, left, pos);
                    break;
                }
                left--;
                right--;
            }
            reverse(nums, left + 1);
        }

        private void swap(int[] nums, int left, int right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }

        private void reverse(int[] nums, int start) {
            int end = nums.length - 1;
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
