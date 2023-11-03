package beijing;
/*
https://leetcode.cn/problems/prime-arrangements/
 */

public class numPrimeArrangements {
    // 这个简单题不简单，自己没写出来
    static class Solution {
        private final int MOD = 1000000007;

        public int numPrimeArrangements(int n) {
            int primeCount = 0;
            for (int i = 1; i <= n; i++) {
                if (isPrime(i)) {
                    primeCount++;
                }
            }
            return (int) (factor(primeCount) * factor(n - primeCount) % MOD);
        }

        private boolean isPrime(int x) {
            if (x == 1) {
                return false;
            }
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }

        private long factor(int x) {
            long count = 1;
            for (int i = 2; i <= x; i++) {
                count *= i;
                count %= MOD;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(new Solution().numPrimeArrangements(n));
    }
}
