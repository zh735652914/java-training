package LeetCode;

/*
204. Count Primes
Easy

1461

489

Add to List

Share
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
//很奇怪，自己写的不对。。。
class CountPrimesSolution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrinme = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrinme[i]) count++;
            for (int j = 2; i * j < n; j++) {
                notPrinme[i * j] = true;
            }
        }
        return count;
    }
}

public class CountPrimes {
    public static void main(String[] args) {
        int n = 499979;
        System.out.println(new CountPrimesSolution().countPrimes(n));
    }
}
