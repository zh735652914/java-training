package beijing;
/*
https://leetcode.cn/problems/3sum-closest/
 */

import java.util.Arrays;

// 第三次写了，感觉自己写的不太行
public class threeSumClosest_16 {
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans = -1;
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    int diff = Math.abs(sum - target);
                    if (diff <= minDiff) {
                        minDiff = diff;
                        ans = sum;
                    }
                    if (sum < target) {
                        while (left + 1 < nums.length - 1 && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else if (sum > target) {
                        while (right - 1 > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else {
                        return sum;
                    }
                }
                while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            return ans;
        }
    }

    static class Solution0 {
        public int threeSumClosest(int[] nums, int target) {
            int minDiff = Integer.MAX_VALUE;
            int ans = -1;
            Arrays.sort(nums);
            boolean hasFind = false;
            for (int i = 0; i < nums.length - 2 && !hasFind; i++) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    int diff = Math.abs(target - sum);
                    if (diff == 0) {
                        ans = sum;
                        hasFind = true;
                        break;
                    } else if (diff < minDiff) {
                        minDiff = diff;
                        ans = sum;
                    }
                    if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        int target = 0;
        // [-5, -5, -4, 0, 0, 3, 3, 4, 5]
//        int[] nums = {-763, 567, 885, -628, -530, -468, 549, -341, 275, -282, 22, -448, -804, -369, 636, -677, -907, 898, 8, -643, 213, 245, 756, -328, -987, -433, 639, -18, -104, -439, 715, -145, -703, 299, -84, 767, 818, -300, -374, 232, 962, -289, 638, 144, -508, 870, 480, -70, -576, 661, -808};
//        int target = -2145;
        System.out.println(new Solution().threeSumClosest(nums, target));
    }
}
