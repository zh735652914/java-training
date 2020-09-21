package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：29136
本题知识点： 数组 动态规划
 算法知识视频讲解
题目描述
假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
示例1
输入
复制
[1,4,2]
输出
复制
3
示例2
输入
复制
[2,4,1]
输出
复制
2
 */

public class maxProfit {
    static public class Solution {
        /**
         * @param prices int整型一维数组
         * @return int整型
         */
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }
            int[][] dp = new int[prices.length][2];
            dp[0][1] = -prices[0];
            dp[0][0] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
            }
            return dp[prices.length - 1][0];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 10};
        System.out.println(new Solution().maxProfit(nums));
    }
}
