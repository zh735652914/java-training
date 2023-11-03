package beijing;
/*
https://leetcode.cn/problems/container-with-most-water/
 */

/**
 * @author zhouhao
 * @date 2023/3/16 12:54
 */
public class ContainerWithMostWater_11_HotOneHundred {
    // 第五次了，自己还是不会写
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
