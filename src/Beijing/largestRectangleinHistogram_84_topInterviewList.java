package Beijing;
/*
https://leetcode.cn/problems/largest-rectangle-in-histogram/
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class largestRectangleinHistogram_84_topInterviewList {
    // 这种方法自己不会写，需要多研究研究
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            // 不理解Deque双端队列为什么要比stack快
            Deque<Integer> stack = new ArrayDeque<>();
            int ans = 0;
            int[] tmp = new int[heights.length + 2];
            System.arraycopy(heights, 0, tmp, 1, heights.length);
            for (int i = 0; i < tmp.length; i++) {
                while (!stack.isEmpty() && tmp[stack.peek()] > tmp[i]) {
                    int h = tmp[stack.pop()];
                    ans = Math.max(ans, (i - stack.peek() - 1) * h);
                }
                stack.push(i);
            }
            return ans;
        }
    }

    // 暴力过不了
    static class Solution0 {
        public int largestRectangleArea(int[] heights) {
            int ans = 0;
            for (int i = 0; i < heights.length; i++) {
                int j = i;
                int w = 1;
                while (--j >= 0 && heights[j] >= heights[i]) {
                    w++;
                }
                j = i;
                while (++j < heights.length && heights[j] >= heights[i]) {
                    w++;
                }
                ans = Math.max(ans, w * heights[i]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}
