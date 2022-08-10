package Beijing;
/*
https://leetcode.cn/problems/solve-the-equation/
 */

public class solveEquation {
    // 写起来要考虑各种情况
    static class Solution {
        public String solveEquation(String equation) {
            String[] s = equation.split("=");
            String left = s[0];
            String right = s[1];
            int[] L = getEquation(left);
            int[] R = getEquation(right);
            int xCount = L[0] - R[0];
            int rCount = R[1] - L[1];
            if (rCount == 0 && xCount == 0) {
                return "Infinite solutions";
            } else if (rCount == 0) {
                return "x=0";
            } else if (xCount == 0) {
                return "No solution";
            } else {
                return "x=" + rCount / xCount;
            }
        }

        private int[] getEquation(String s) {
            int X = 0, R = 0;
            int len = s.length();
            boolean positive = true;
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    int start = i;
                    i++;
                    while (i < len && Character.isDigit(s.charAt(i))) {
                        i++;
                    }
                    if (i < len && s.charAt(i) == 'x') {
                        X += positive ? getNum(s.substring(start, i)) : -getNum(s.substring(start, i));
                    } else {
                        R += positive ? getNum(s.substring(start, i)) : -getNum(s.substring(start, i));
                        i--;
                    }
                } else if (ch == 'x') {
                    X += positive ? 1 : -1;
                } else positive = ch != '-';
            }
            return new int[]{X, R};
        }

        private int getNum(String s) {
            int num = 0, len = s.length();
            for (int i = 0; i < len; i++) {
                num *= 10;
                num += s.charAt(i) - '0';
            }
            return num;
        }
    }

    public static void main(String[] args) {
        String equation = "-x=-1";
        System.out.println(new Solution().solveEquation(equation));
    }
}
