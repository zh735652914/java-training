package beijing;
/*
https://leetcode.cn/problems/na-ying-bi/?envType=daily-question&envId=2023-09-20
 */

/**
 * @author zhouhao
 * @date 2023/9/20 22:37
 */
public class MinCount {
    // 简单题
    static class Solution {
        public int minCount(int[] coins) {
            int count = 0;
            for (int coin : coins) {
                while (coin >= 2) {
                    count++;
                    coin -= 2;
                }
                if (coin > 0) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] coins = {4, 2, 1};
        System.out.println(new Solution().minCount(coins));
    }
}
