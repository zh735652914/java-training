package leetcode;

/*
172. Factorial Trailing Zeroes
Easy

607

864

Add to List

Share
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.
 */
//自己不会写，看了Discuss，感觉自己是傻子。。。
class FactorialTrailingZeroesSolution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
//        int n = 25;
        int n = 99;//22
//        int n = 100;//24
//        int n = 55;
        System.out.println(new FactorialTrailingZeroesSolution().trailingZeroes(n));
    }
}
