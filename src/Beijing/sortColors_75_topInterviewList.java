package Beijing;
/*
https://leetcode.cn/problems/sort-colors/
 */

public class sortColors_75_topInterviewList {
    // 自己没写出来
    static class Solution {
        public void sortColors(int[] nums) {
            int left = 0, right = nums.length - 1;
            for (int i = 0; i <= right; i++) {
                while (nums[i] == 2 && i <= right) {
                    swap(nums, i, right);
                    right--;
                }
                if (nums[i] == 0) {
                    swap(nums, i, left);
                    left++;
                }
            }
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        new Solution().sortColors(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
