package Beijing.hot100;
/*
https://leetcode.cn/problems/container-with-most-water/
 */

// 第二次写了，自己居然还是没想出来思路
public class containerWithMostWater {
    static class Solution {
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int ans = 0;
            while (left < right) {
                if (height[left] < height[right]) {
                    ans = Math.max(ans, height[left] * (right - left));
                    left++;
                } else {
                    ans = Math.max(ans, height[right] * (right - left));
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
