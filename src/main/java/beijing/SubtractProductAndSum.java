package beijing;
/*
https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */

/**
 * @author zhouhao
 * @date 2023/8/9 12:51
 */
public class SubtractProductAndSum {
    // 很简单的题目
    static class Solution {
        public int subtractProductAndSum(int n) {
            int product = 1, sum = 0;
            while (n > 0) {
                int x = n % 10;
                sum += x;
                product *= x;
                n /= 10;
            }
            return product - sum;
        }
    }

    public static void main(String[] args) {
        int n = 234;
        System.out.println(new Solution().subtractProductAndSum(n));
    }
}
