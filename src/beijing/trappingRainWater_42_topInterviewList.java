package beijing;
/*
https://leetcode.cn/problems/trapping-rain-water/
 */

public class trappingRainWater_42_topInterviewList {
    // 官方解析二，自己没写出来
    static class Solution {
        public int trap(int[] height) {
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            int ans = 0;
            while (left < right) {
                leftMax = Math.max(height[left], leftMax);
                rightMax = Math.max(height[right], rightMax);
                if (leftMax <= rightMax) {
                    ans += leftMax - height[left];
                    left++;
                } else {
                    ans += rightMax - height[right];
                    right--;
                }
            }
            return ans;
        }
    }

    // 官方解析的动态规划，自己没想到
    static class Solution1 {
        public int trap(int[] height) {
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            leftMax[0] = height[0];
            rightMax[height.length - 1] = height[height.length - 1];
            for (int i = 1; i < height.length; i++) {
                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            }
            for (int i = height.length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(height[i], rightMax[i + 1]);
            }
            int ans = 0;
            for (int i = 0; i < height.length; i++) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }
    }

    // 写是写出来了，但是效率太低
    static class Solution0 {
        public int trap(int[] height) {
            int ans = 0;
            int minHeight = Integer.MAX_VALUE;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > 0 && minHeight > height[i]) {
                    minHeight = height[i];
                }
            }
            if (minHeight == Integer.MAX_VALUE) {
                return 0;
            }
            int count = 0;
            int left = 0, right = height.length - 1;
            while (left <= right) {
                if (height[left] >= minHeight) {
                    break;
                }
                left++;
            }
            while (left <= right) {
                if (height[right] >= minHeight) {
                    break;
                }
                right--;
            }
            for (int i = left; i <= right; i++) {
                if (height[i] < minHeight) {
                    count++;
                }
            }
            ans += count * minHeight;
            for (int i = 0; i < height.length; i++) {
                height[i] = height[i] > minHeight ? height[i] - minHeight : 0;
            }
            ans += trap(height);
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));
    }
}
