package Beijing;
/*
https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */

public class KthLargestElementinanArray_215_topInterviewList {
    // 需要背下来
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            return arrayPartition(nums, 0, nums.length - 1, nums.length - k);
        }

        private int arrayPartition(int[] nums, int low, int high, int k) {
            int pos = partition(nums, low, high);
            if (pos == k) {
                return nums[pos];
            }
            if (pos < k) {
                return arrayPartition(nums, pos + 1, high, k);
            } else {
                return arrayPartition(nums, low, pos - 1, k);
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
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new Solution().findKthLargest(nums, k));
    }
}
