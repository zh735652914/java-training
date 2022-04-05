package Beijing;
/*
https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/comments/
 */

public class countPrimeSetBits {
    static class Solution {
        public int countPrimeSetBits(int left, int right) {
            int count = 0;
            for (int i = left; i <= right; i++) {
                if (isPrime(Integer.bitCount(i))) {
                    count++;
                }
            }
            return count;
        }

        private boolean isPrime(int x) {
            if (x < 2) {
                return false;
            }
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int left = 6, right = 10;
        System.out.println(new Solution().countPrimeSetBits(left, right));
    }
}
