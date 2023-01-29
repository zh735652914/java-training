package beijing;
/*
https://leetcode.cn/problems/rotated-digits/
 */

public class rotatedDigits {
    // 自己写的效率一般
    static class Solution {
        public int rotatedDigits(int n) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                int num = getNum(i);
                if (num > 0 && num != i) {
                    count++;
                }
            }
            return count;
        }

        private int getNum(int n) {
            int num = 0;
            int pow = 1;
            while (n > 0) {
                int x = getRotated(n % 10);
                if (x < 0) {
                    return -1;
                }
                num += x * pow;
                pow *= 10;
                n /= 10;
            }
            return num;
        }

        private int getRotated(int n) {
            switch (n) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 5;
                case 5:
                    return 2;
                case 6:
                    return 9;
                case 8:
                    return 8;
                case 9:
                    return 6;
                default:
                    return -1;
            }
        }
    }

    public static void main(String[] args) {
        int n = 857;
        System.out.println(new Solution().rotatedDigits(n));
    }
}
