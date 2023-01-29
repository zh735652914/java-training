package beijing;
/*
https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */

public class kthLargestElementinanArray_215 {
    // 自己还是不会写，这个快排很重要
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            partitionArrays(nums, 0, nums.length - 1, nums.length - k);
            return nums[nums.length - k];
        }

        private void partitionArrays(int[] nums, int low, int high, int k) {
            int m = partition(nums, low, high);
            if (m == k) {
                return;
            } else if (k < m) {
                partitionArrays(nums, low, m - 1, k);
            } else {
                partitionArrays(nums, m + 1, high, k);
            }
        }

        private int partition(int[] nums, int low, int high) {
            int i = low;
            int j = high + 1;
            int v = nums[low];
            while (true) {
                while (++i < high && nums[i] < v) {
                }
                while (--j > low && nums[j] > v) {
                }
                if (i >= j) {
                    break;
                }
                swap(nums, i, j);
            }
            swap(nums, low, j);
            return j;
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 1, 5, 6, 4};
//        int k = 2;
        int[] nums = {3};
        int k = 1;
        System.out.println(new Solution().findKthLargest(nums, k));
    }
}
