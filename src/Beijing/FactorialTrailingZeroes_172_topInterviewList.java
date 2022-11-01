package Beijing;
/*
https://leetcode.cn/problems/factorial-trailing-zeroes/
 */

public class FactorialTrailingZeroes_172_topInterviewList {
    // 自己还是不会写
    static class Solution {
        public int trailingZeroes(int n) {
            int ans = 0;
            while (n > 0) {
                n /= 5;
                ans += n;
            }
            return ans;
        }
    }

    // 自己写的还是太慢
    static class Solution0 {
        public int trailingZeroes(int n) {
            // 2,5
            int count2 = 0, count5 = 0;
            while (n > 1) {
                int x = n;
//                System.out.println(x);
                while (x > 1) {
                    boolean flag = false;
                    if (x % 2 == 0) {
                        count2++;
                        x >>= 1;
                        flag = true;
                    }
                    if (x % 5 == 0) {
                        count5++;
                        x /= 5;
                        flag = true;
                    }
                    if (!flag) {
                        break;
                    }
                }
                n--;
            }
            return Math.min(count2, count5);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().trailingZeroes(n));
    }
}
