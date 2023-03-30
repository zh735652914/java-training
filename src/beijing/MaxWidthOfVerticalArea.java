package beijing;
/*
https://leetcode.cn/problems/widest-vertical-area-between-two-points-containing-no-points/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/3/30 12:42
 */
public class MaxWidthOfVerticalArea {
    // 这是中等难度的题？
    static class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            Arrays.sort(points, (o1, o2) -> (o1[0] - o2[0]));
            int ans = 0;
            for (int i = 1; i < points.length; i++) {
                ans = Math.max(ans, points[i][0] - points[i - 1][0]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] points = {{8, 7}, {9, 9}, {7, 4}, {9, 7}};
        System.out.println(new Solution().maxWidthOfVerticalArea(points));
    }
}
