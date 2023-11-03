package beijing;

/*
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class removeDuplicates {
    static class Solution {
        public int removeDuplicates2(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            int count = 1, last = nums[0], p = 1;
            while (p < nums.length) {
                if (nums[p] != last) {
                    nums[count++] = nums[p];
                    last = nums[p];
                } else {
                    p++;
                }
            }
            return count;
        }

        public int removeDuplicates(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            int left = 0, right = 0;
            while (right < nums.length) {
                while (right < nums.length && nums[right] == nums[left]) {
                    right++;
                }
                if (right < nums.length) {
                    nums[++left] = nums[right];
                }
                right++;
            }
            return left + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2};
        int len = new Solution().removeDuplicates2(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
