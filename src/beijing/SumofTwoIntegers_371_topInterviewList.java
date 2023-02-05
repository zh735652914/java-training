package beijing;
/*
https://leetcode.cn/problems/sum-of-two-integers/
 */

/**
 * @author zhouhao
 * @date 2023/2/5 13:17
 */
// 第二次写了，自己还是不会
public class SumofTwoIntegers_371_topInterviewList {
    static class Solution {
        public int getSum(int a, int b) {
            int carry;
            while (b != 0) {
                carry = (a & b) << 1;
                a = a ^ b;
                b = carry;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        int a = 1, b = 2;
        System.out.println(new Solution().getSum(a, b));
    }
}
