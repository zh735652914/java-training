package leetcode;


import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        int ans = 0;
        Arrays.sort(nums);
        int closestDis = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    int tmp = target - sum;
                    if (tmp < closestDis) {
                        closestDis = tmp;
//                        l++;
                        ans = sum;
                    }
                    l++;
                } else if (sum > target) {
                    int tmp = sum - target;
                    if (tmp < closestDis) {
                        closestDis = tmp;
                        ans = sum;
                    }
                    r--;
                } else {
                    return sum;
                }
            }
        }
        return ans;
    }
}

public class threeSumClosest {
    public static void main(String[] args) {
        Solution SC = new Solution();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int ans = SC.threeSumClosest(nums, target);
        System.out.println("ans=" + ans);
    }
}
