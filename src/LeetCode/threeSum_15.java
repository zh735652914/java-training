package LeetCode;
/*
https://leetcode-cn.com/problems/3sum/
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：

输入：nums = []
输出：[]
示例 3：

输入：nums = [0]
输出：[]


提示：

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
通过次数463,012提交次数1,468,917
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum_15 {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = -nums[i];
                int L = i + 1, R = nums.length - 1;
                while (L < R) {
                    int tmp = nums[L] + nums[R];
                    if (tmp == target) {
                        List<Integer> aAns = new ArrayList<>(3);
                        aAns.add(nums[i]);
                        aAns.add(nums[L]);
                        aAns.add(nums[R]);
                        ans.add(aAns);
                        L++;
                        while (L < R && nums[L] == nums[L - 1]) {
                            L++;
                        }
                    } else if (tmp > target) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums));
    }
}
