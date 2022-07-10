package Beijing;
/*
https://leetcode.cn/problems/container-with-most-water/
 */

public class containerWithMostWater_11 {
    // 第三次写了，一开始还是不会，问题很大
    static class Solution {
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int ans = 0;
            while (left < right) {
                int x = Math.min(height[left], height[right]) * (right - left);
                ans = Math.max(ans, x);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(height));
    }
}
