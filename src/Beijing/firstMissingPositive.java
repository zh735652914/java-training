package Beijing;
/*
https://leetcode-cn.com/problems/first-missing-positive/
 */

public class firstMissingPositive {
    // 这个思路想不到
    static class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                    int spare = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    while (spare > 0 && spare <= nums.length && nums[spare - 1] != spare) {
                        int tmp = spare;
                        spare = nums[spare - 1];
                        nums[tmp - 1] = tmp;
                    }
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}
