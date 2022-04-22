package Beijing;
/*
https://leetcode-cn.com/problems/rectangle-area/
 */

public class computeArea {
    // 自己没写出来，需要看看，容易迷糊
    static class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int area1 = (ax1 - ax2) * (ay1 - ay2);
            int area2 = (bx2 - bx1) * (by2 - by1);
            if (bx1 >= ax2 || bx2 <= ax1 || by2 <= ay1 || by1 >= ay2) {
                return area1 + area2;
            }
            int topX = Math.min(ax2, bx2);
            int topY = Math.min(ay2, by2);
            int buttomX = Math.max(ax1, bx1);
            int buttomY = Math.max(ay1, by1);
            return area1 - (topX - buttomX) * (topY - buttomY) + area2;
        }
    }

    public static void main(String[] args) {
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        System.out.println(new Solution().computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }
}
