package LeetCode.ToOffer;
/*
剑指 Offer 51. 数组中的逆序对
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。



示例 1:

输入: [7,5,6,4]
输出: 5


限制：

0 <= 数组长度 <= 50000

通过次数39,466提交次数85,820
 */

public class reversePairs {
    static class Solution {
        int sum = 0;

        public int reversePairs(int[] nums) {
            backtrack(nums, 0, nums.length - 1);
            return sum;
        }

        private void backtrack(int[] nums, int left, int right) {
            if (left < right) {
                int mid = (left + right) >> 1;
                backtrack(nums, left, mid);
                backtrack(nums, mid + 1, right);
                merge(nums, left, right, mid);
            }
        }

        private void merge(int[] nums, int left, int right, int mid) {
            int L = left, R = mid + 1, index = 0;
            int[] tmp = new int[right - left + 1];
            while (L <= mid && R <= right) {
                if (nums[L] > nums[R]) {
                    sum += mid - L + 1;
                    tmp[index++] = nums[R++];
                } else {
                    tmp[index++] = nums[L++];
                }
            }
            while (L <= mid) {
                tmp[index++] = nums[L++];
            }
            while (R <= right) {
                tmp[index++] = nums[R++];
            }
            for (int i = 0; i < index; i++) {
                nums[left + i] = tmp[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        System.out.println(new Solution().reversePairs(nums));
    }
}
