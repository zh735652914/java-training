package Beijing.hot100;
/*
https://leetcode.cn/problems/3sum/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    // 第二次写，还是不太会，而且效率太低了
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                while (i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
                    i++;
                }
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum >= -nums[i]) {
                        if (sum == -nums[i]) {
                            List<Integer> aThree = new ArrayList<>(3);
                            aThree.add(nums[i]);
                            aThree.add(nums[left]);
                            aThree.add(nums[right]);
                            ans.add(aThree);
                        }
                        right--;
                        while (right > left && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum > -nums[i]) {
                        right--;
                    } else {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 2, 2, 3, 0, 1, 2, 3, -1, -4, 2};
        System.out.println(new Solution().threeSum(nums));
    }
}
