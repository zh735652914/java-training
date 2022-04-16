package Beijing;
/*
https://leetcode-cn.com/problems/count-primes/
 */

public class countPrimes {
    // 这个官方写的，一直计算合数
    static class Solution {
        public int countPrimes(int n) {
            int[] count = new int[n];
            int ans = 0;
            for (int i = 2; i < n; i++) {
                if (count[i] == 0) {
                    ans++;
                }
                for (int j = 2 * i; j < n; j += i) {
                    count[j]++;
                }
            }
            return ans;
        }
    }

    // 这个是官方解答，也超时了
    static class Solution0 {
        public int countPrimes(int n) {
            int ans = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime(i)) {
                    ans++;
                }
            }
            return ans;
        }

        private boolean isPrime(int x) {
            if (x == 1) {
                return true;
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
        int n = 10;
        System.out.println(new Solution().countPrimes(n));
    }
}
