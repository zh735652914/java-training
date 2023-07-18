package beijing;
/*
https://leetcode.cn/problems/sort-colors/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/7/18 12:55
 */
public class SortColors_75_HotOneHundred {
    static class Solution {
        // 还是得看解析
        public void sortColors(int[] nums) {
            int left = 0, right = nums.length - 1;
            for (int i = 0; i < nums.length && i <= right; i++) {
                while (i <= right && nums[i] == 2) {
                    swap(nums, i, right);
                    right--;
                }
                if (nums[i] == 0) {
                    swap(nums, i, left);
                    left++;
                }
            }
        }

        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
