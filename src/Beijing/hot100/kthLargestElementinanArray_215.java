package Beijing.hot100;
/*
https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */

// 【很重要，快排序】第二次写还是不会
public class kthLargestElementinanArray_215 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int pos = partition(nums, low, high);
                if (pos == k) {
                    return nums[pos];
                } else if (pos < k) {
                    low = pos + 1;
                } else {
                    high = pos - 1;
                }
            }
            return -1;
        }

        private int partition(int[] nums, int low, int high) {
            int i = low;
            int j = high + 1;
            int v = nums[low];
            while (true) {
                while (++i <= high && nums[i] < v) ;
                while (--j >= low && nums[j] > v) ;
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
