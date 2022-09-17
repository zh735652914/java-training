package Beijing;
/*
https://leetcode.cn/problems/next-permutation/
 */

// 还是需要看官方解析才写的出来
public class nextPermutation_31_topInterviewList {
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
                    swap(nums, pos, left);
                    break;
                }
                left--;
                right--;
            }
            reverse(nums, left + 1);
        }

        private void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {4, 5, 2, 6, 3, 1};// 4,5,3,1,2,6
        int[] nums = {3, 2, 1};
        new Solution().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
