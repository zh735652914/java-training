package beijing;
/*
https://leetcode-cn.com/problems/reaching-points/
 */

public class reachingPoints {
    // 说实话自己不太好想到这个
    static class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            if (sx == tx && sy == ty) {
                return true;
            }
            if (tx == ty || tx < sx || ty < sy) {
                return false;
            }
            if (sx == tx) {
                return (ty - sy) % tx == 0;
            }
            if (sy == ty) {
                return (tx - sx) % ty == 0;
            }
            if (tx >= ty) {
                return reachingPoints(sx, sy, tx % ty, ty);
            } else {
                return reachingPoints(sx, sy, tx, ty % tx);
            }
        }
    }

    public static void main(String[] args) {
        int sx = 1, sy = 1, tx = 3, ty = 5;
        System.out.println(new Solution().reachingPoints(sx, sy, tx, ty));
    }
}
