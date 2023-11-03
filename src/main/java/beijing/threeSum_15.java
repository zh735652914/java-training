package beijing;
/*
https://leetcode.cn/problems/3sum/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum_15 {
    // 中间加一个二分
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == -nums[i]) {
                        List<Integer> three = new ArrayList<>();
                        three.add(nums[i]);
                        three.add(nums[left]);
                        three.add(nums[right]);
                        ans.add(three);
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < -nums[i]) {
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
