package LeetCode;
/*
https://leetcode-cn.com/problems/4sum/
18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：答案中不可以包含重复的四元组。



示例 1：

输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：

输入：nums = [], target = 0
输出：[]


提示：

0 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
通过次数165,959提交次数413,832
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum_18 {
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int first = target - nums[i];
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int second = first - nums[j];
                    int L = j + 1, R = nums.length - 1;
                    while (L < R) {
                        int sum = nums[L] + nums[R];
                        if (sum > second) {
                            R--;
                            while (L < R && nums[R] == nums[R + 1]) {
                                R--;
                            }
                        } else if (sum < second) {
                            L++;
                            while (L < R && nums[L] == nums[L - 1]) {
                                L++;
                            }
                        } else {
                            List<Integer> aAns = new ArrayList<>(4);
                            aAns.add(nums[i]);
                            aAns.add(nums[j]);
                            aAns.add(nums[L]);
                            aAns.add(nums[R]);
                            ans.add(aAns);
                            L++;
                            while (L < R && nums[L] == nums[L - 1]) {
                                L++;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        int target = 0;
        System.out.println(new Solution().fourSum(nums, target));
    }
}
