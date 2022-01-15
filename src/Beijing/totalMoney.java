package Beijing;
/*
https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank/
 */

public class totalMoney {
    static class Solution {
        public int totalMoney(int n) {
            int count = n / 7, remain = n % 7, week = (1 + 7) * 7 / 2;
            int sum = 0, k = 0;
            while (k < count) {
                sum += week + 7 * k;
                k++;
            }
            if (remain > 0) {
                sum += (1 + remain) * remain / 2 + count * remain;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(new Solution().totalMoney(n));
    }
}
