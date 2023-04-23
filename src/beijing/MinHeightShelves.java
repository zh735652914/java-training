package beijing;
/*
https://leetcode.cn/problems/filling-bookcase-shelves/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/4/23 12:27
 */
public class MinHeightShelves {
    // 又是不会的一题
    static class Solution {
        public int minHeightShelves(int[][] books, int shelfWidth) {
            /*
            dp[i] 来表示放下前 i 本书所用的最小高度
            dp[i]=Math.min(dp[j]+max(books[k][1]))
             */
            int[] dp = new int[books.length + 1];
            Arrays.fill(dp, 1000000);
            dp[0] = 0;
            for (int i = 0; i < books.length; i++) {
                int width = 0, high = 0;
                for (int j = i; j >= 0 && width <= shelfWidth; j--) {
                    width += books[j][0];
                    if (width > shelfWidth) {
                        break;
                    }
                    high = Math.max(high, books[j][1]);
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + high);
                }
            }
            return dp[books.length];
        }
    }

    public static void main(String[] args) {
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelfWidth = 4;
        System.out.println(new Solution().minHeightShelves(books, shelfWidth));
    }
}
