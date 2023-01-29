package beijing;
/*
https://leetcode-cn.com/problems/zigzag-conversion/
 */

public class ZigZagConversion {
    // 自己不会，难受
    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1 || numRows >= s.length()) {
                return s;
            }
            StringBuilder[] stringBuilders = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                stringBuilders[i] = new StringBuilder();
            }
            int index = 0, dir = -1;
            for (int i = 0; i < s.length(); i++) {
                stringBuilders[index].append(s.charAt(i));
                if (index == 0 || index == numRows - 1) {
                    dir = -dir;
                }
                index += dir;
            }
            StringBuilder ans = new StringBuilder();
            for (StringBuilder x : stringBuilders) {
                ans.append(x);
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(new Solution().convert(s, numRows));
    }
}
