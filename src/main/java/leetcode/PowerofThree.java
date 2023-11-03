package leetcode;
/*
326. Power of Three
Easy

384

1270

Add to List

Share
Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?
 */

//自己没写出来，这个方法，只能说，牛逼牛逼
class PowerofThreeSolution {
    public boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }
}

public class PowerofThree {
    public static void main(String[] args) {
        int n = 72;
        System.out.println(new PowerofThreeSolution().isPowerOfThree(n));
    }
}
