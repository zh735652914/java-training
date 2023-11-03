package beijing;
/*
https://leetcode.cn/problems/3sum/description/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/7/9 12:42
 */
public class ThreeSum {
    // 实际上是双指针
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (nums[i] == -sum) {
                        List<Integer> aPir = new ArrayList<>();
                        aPir.add(nums[i]);
                        aPir.add(nums[left]);
                        aPir.add(nums[right]);
                        ans.add(aPir);
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (nums[i] < -sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
                while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
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
