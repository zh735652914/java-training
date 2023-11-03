package beijing;
/*
https://leetcode.cn/problems/height-checker/
 */

import java.util.Arrays;

public class heightChecker {
    // 官方解析的计数排序法还是要看看
    static class Solution {
        public int heightChecker(int[] heights) {
            int[] sorted = new int[heights.length];
            System.arraycopy(heights, 0, sorted, 0, heights.length);
            Arrays.sort(sorted);
            int count = 0;
            for (int i = 0; i < sorted.length; i++) {
                if (sorted[i] != heights[i]) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        System.out.println(new Solution().heightChecker(heights));
    }
}
