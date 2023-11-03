package beijing;
/*
https://leetcode.cn/problems/valid-square/
 */

import java.util.Arrays;

// 这个写法还是要看看
public class validSquare {
    static class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            if (Arrays.equals(p1, p2)) {
                return false;
            }
            if (help(p1, p2, p3, p4)) {
                return true;
            }
            if (Arrays.equals(p1, p3)) {
                return false;
            }
            if (help(p1, p3, p2, p4)) {
                return true;
            }
            if (Arrays.equals(p1, p4)) {
                return false;
            }
            return help(p1, p4, p2, p3);
        }

        private boolean help(int[] p1, int[] p2, int[] p3, int[] p4) {
            int[] v1 = new int[]{p1[0] - p2[0], p1[1] - p2[1]};
            int[] v2 = new int[]{p3[0] - p4[0], p3[1] - p4[1]};
            return checkLength(v1, v2) && checkMidPoint(p1, p2, p3, p4) && checkCos(v1, v2);
        }

        private boolean checkLength(int[] v1, int[] v2) {
            return (v1[0] * v1[0] + v1[1] * v1[1]) == (v2[0] * v2[0] + v2[1] * v2[1]);
        }

        private boolean checkMidPoint(int[] p1, int[] p2, int[] p3, int[] p4) {
            return (p1[0] + p2[0]) == (p3[0] + p4[0]) && (p1[1] + p2[1]) == (p3[1] + p4[1]);
        }

        private boolean checkCos(int[] v1, int[] v2) {
            return (v1[0] * v2[0] + v1[1] * v2[1]) == 0;
        }
    }

    public static void main(String[] args) {
        int[] p1 = {0, 0}, p2 = {1, 1}, p3 = {1, 0}, p4 = {0, 1};
        System.out.println(new Solution().validSquare(p1, p2, p3, p4));
    }
}
