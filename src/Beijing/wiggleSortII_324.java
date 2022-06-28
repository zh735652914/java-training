package Beijing;
/*
https://leetcode.cn/problems/wiggle-sort-ii/
 */

import java.util.Arrays;

public class wiggleSortII_324 {
    // 自己还是没写出来
    static class Solution {
        public void wiggleSort(int[] nums) {
            int[] arr = nums.clone();
            Arrays.sort(arr);
            for (int i = 0, j = (arr.length + 1) / 2 - 1, k = arr.length - 1; i < arr.length; i += 2, j--, k--) {
                nums[i] = arr[j];
                if (i + 1 < arr.length) {
                    nums[i + 1] = arr[k];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        new Solution().wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
