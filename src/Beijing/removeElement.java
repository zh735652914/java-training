package Beijing;

/*
https://leetcode-cn.com/problems/remove-element/
 */
public class removeElement {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            }
            int left = 0, right = 0;
            while (right < nums.length) {
                if (nums[right] != val) {
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int len = new Solution().removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
