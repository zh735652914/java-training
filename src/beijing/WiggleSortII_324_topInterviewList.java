package beijing;
/*
https://leetcode.cn/problems/wiggle-sort-ii/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/1/3 13:06
 */
public class WiggleSortII_324_topInterviewList {
    // 自己还是没写出来，遍历的方向要注意
    static class Solution {
        public void wiggleSort(int[] nums) {
            int[] tmp = nums.clone();
            Arrays.sort(tmp);
            int left = (nums.length + 1) / 2 - 1, right = nums.length - 1, index = 0;
            while (left >= 0 && right >= 0 && index < nums.length) {
                nums[index++] = tmp[left--];
                if (index >= nums.length) {
                    break;
                }
                nums[index++] = tmp[right--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        new Solution().wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
