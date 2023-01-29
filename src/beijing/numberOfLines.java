package beijing;
/*
https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 */

public class numberOfLines {
    static class Solution {
        public int[] numberOfLines(int[] widths, String s) {
            if (s.length() < 1) {
                return new int[]{0, 0};
            }
            int row = 1;
            int col = 0;
            for (int i = 0; i < s.length(); i++) {
                int x = widths[s.charAt(i) - 'a'];
                col += x;
                if (col > 100) {
                    row++;
                    col = x;
                }
            }
            return new int[]{row, col};
        }
    }

    public static void main(String[] args) {
        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String S = "abcdefghijklmnopqrstuvwxyz";
        int[] ans = new Solution().numberOfLines(widths, S);
        System.out.println(ans[0] + ", " + ans[1]);
    }
}
