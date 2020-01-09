package LeetCode;
/*
371. Sum of Two Integers
Easy

965

1803

Add to List

Share
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = -2, b = 3
Output: 1
 */

//这题不会。。。
//很重要！！！
class SumofTwoIntegersSolution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}

public class SumofTwoIntegers {
    public static void main(String[] args) {
        int a = -2;
        int b = 3;
        System.out.println(new SumofTwoIntegersSolution().getSum(a, b));
    }
}
