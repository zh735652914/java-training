package Beijing;
/*
https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */

public class removeDuplicatesfromSortedArray_26_topInterviewList {
    // 写了很多次了，但这次一开始居然有点懵
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int len = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[len++] = nums[i];
                }
            }
            return len;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = new Solution().removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ", ");
        }
    }
}
