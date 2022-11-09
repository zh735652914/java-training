package Beijing;
/*
https://leetcode.cn/problems/count-primes/
 */

import java.util.Arrays;

public class CountPrimes_204_topInterviewList {
    // 自己还是不会写
    static class Solution {
        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            for (int i = 2; i * i < n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 499979;
        System.out.println(new Solution().countPrimes(n));
    }
}
