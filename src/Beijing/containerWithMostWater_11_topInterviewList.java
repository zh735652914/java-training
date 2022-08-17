package Beijing;
/*
https://leetcode.cn/problems/container-with-most-water/
 */

// 第四次写了，还是没写出来
public class containerWithMostWater_11_topInterviewList {
    static class Solution {
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int ans = 0;
            while (left < right) {
                ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
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
