package Beijing.hot100;
/*
https://leetcode.cn/problems/sort-colors/
 */

// 很重要！自己还是没写出来
public class sortColors_75 {
    static class Solution {
        public void sortColors(int[] nums) {
            int left = 0, right = nums.length - 1;
            int index = 0;
            while (index <= right) {
                while (index <= right && nums[index] == 2) {
                    swap(nums, index, right);
                    right--;
                }
                if (nums[index] == 0) {
                    swap(nums, index, left);
                    left++;
                }
                index++;
            }
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }

    static class Solution0 {
        public void sortColors(int[] nums) {
            int pre = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    swap(nums, i, pre);
                    pre++;
                }
            }
            for (int i = pre; i < nums.length; i++) {
                if (nums[i] == 1) {
                    swap(nums, i, pre);
                    pre++;
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
//        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums = {1, 2, 0};
        new Solution().sortColors(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
