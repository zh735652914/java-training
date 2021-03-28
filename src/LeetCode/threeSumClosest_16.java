package LeetCode;
/*
https://leetcode-cn.com/problems/3sum-closest/
16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。



示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。


提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
通过次数199,510提交次数434,641
 */

import java.util.Arrays;

public class threeSumClosest_16 {
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int L = i + 1, R = nums.length - 1;
                while (L < R) {
                    int sum = nums[i] + nums[L] + nums[R];
                    if (Math.abs(ans - target) > Math.abs(sum - target)) {
                        ans = sum;
                    }
                    if (sum > target) {
                        R--;
                        while (R > i + 1 && L < R && nums[R] == nums[R + 1]) {
                            R--;
                        }
                    } else if (sum < target) {
                        L++;
                        while (L > i + 1 && L < R && nums[L] == nums[L - 1]) {
                            L++;
                        }
                    } else {
                        return ans;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new Solution().threeSumClosest(nums, target));
    }
}
