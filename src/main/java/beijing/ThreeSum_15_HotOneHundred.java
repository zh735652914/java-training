package beijing;
/*
https://leetcode.cn/problems/3sum/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/3/20 12:41
 */
// 可以改进一下
public class ThreeSum_15_HotOneHundred {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (j != i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int target = -(nums[i] + nums[j]);
                    if (find(nums, target, j + 1, nums.length - 1)) {
                        List<Integer> aPir = new ArrayList<>();
                        aPir.add(nums[i]);
                        aPir.add(nums[j]);
                        aPir.add(target);
                        ans.add(aPir);
                    }
                }
            }
            return ans;
        }

        private boolean find(int[] nums, int target, int left, int right) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums));
    }
}
