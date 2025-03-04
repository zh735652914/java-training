package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/4 08:34
 * https://leetcode.cn/problems/container-with-most-water/
 */
public class LeetCode11 {
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

    @Test
    public void test() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
