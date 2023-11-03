package beijing;
/*
https://leetcode.cn/problems/k-items-with-the-maximum-sum/
 */

/**
 * @author zhouhao
 * @date 2023/7/5 12:08
 */
public class KItemsWithMaximumSum {
    // 的确很简单
    static class Solution {
        public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
            int ans = 0;
            if (numOnes + numZeros < k) {
                ans += numOnes;
                k -= (numOnes + numZeros);
            } else {
                return Math.min(numOnes, k);
            }
            return ans - k;
        }
    }

    public static void main(String[] args) {
        int numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2;
        System.out.println(new Solution().kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k));
    }
}
