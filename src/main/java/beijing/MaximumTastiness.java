package beijing;
/*
https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/6/1 12:43
 */
/*
 避免死循环，这是二分的其中一个模板，可以简单记一下，这样一定不会出错。

while l < r:

l = mid, r = mid - 1, 那么 mid = (l + r + 1) >> 1
r = mid, l = mid + 1, 那么 mid = (l + r) >> 1
 */
public class MaximumTastiness {
    // 这题挺重要的
    static class Solution {
        public int maximumTastiness(int[] price, int k) {
            Arrays.sort(price);
            int left = 0, right = price[price.length - 1] - price[0];
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (check(price, k, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private boolean check(int[] prices, int k, int target) {
            int count = 0;
            for (int i = 1, pre = prices[0]; i < prices.length; i++) {
                if (prices[i] - pre >= target) {
                    count++;
                    pre = prices[i];
                }
            }
            return count + 1 >= k;
        }
    }

    public static void main(String[] args) {
        int[] price = {13, 5, 1, 8, 21, 2};
        int k = 3;
        System.out.println(new Solution().maximumTastiness(price, k));
    }
}
