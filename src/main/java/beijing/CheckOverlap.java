package beijing;
/*
https://leetcode.cn/problems/circle-and-rectangle-overlapping/
 */

/**
 * @author zhouhao
 * @date 2023/6/25 11:04
 */
public class CheckOverlap {
    // 数学
    static class Solution {
        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            int dist = 0;
            if (xCenter > x2 || xCenter < x1) {
                dist += Math.min(Math.pow(x1 - xCenter, 2), Math.pow(x2 - xCenter, 2));
            }
            if (yCenter > y2 || yCenter < y1) {
                dist += Math.min(Math.pow(y1 - yCenter, 2), Math.pow(y2 - yCenter, 2));
            }
            return dist <= radius * radius;
        }
    }

    public static void main(String[] args) {
        int radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1;
        System.out.println(new Solution().checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
    }
}
