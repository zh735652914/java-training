package Beijing;
/*
https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */

// 的确很简单
public class removeDuplicatesfromSortedArray_26 {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int index = 0, pos = 1;
            while (pos < nums.length) {
                while (pos < nums.length && nums[index] == nums[pos]) {
                    pos++;
                }
                if (pos >= nums.length) {
                    break;
                }
                nums[++index] = nums[pos];
                pos++;
            }
            return index + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Solution().removeDuplicates(nums));
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
