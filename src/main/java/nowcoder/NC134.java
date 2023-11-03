package nowcoder;
/*
 牛客题霸-名企高频面试题
股票交易的最大收益
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 256M，其他语言512M 热度指数：139
 算法知识视频讲解
题目描述
假定你知道某只股票每一天价格的变动。
你最多可以同时持有一只股票。但你可以无限次的交易（买进和卖出均无手续费）。
请设计一个函数，计算你所能获得的最大收益。
示例1
输入
复制
[5,4,3,2,1]
输出
复制
0
说明
由于每天股票都在跌，因此不进行任何交易最优。最大收益为0。
示例2
输入
复制
[1,2,3,4,5]
输出
复制
4
说明
第一天买进，最后一天卖出最优。中间的当天买进当天卖出不影响最终结果。最大收益为4。
备注:
总天数不大于200000。保证股票每一天的价格在[1,100]范围内。
 */

public class NC134 {
    static public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 计算最大收益
         *
         * @param prices int整型一维数组 股票每一天的价格
         * @return int整型
         */
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
        }
    }

    public static void main(String[] args) {
        int[] prices = {5, 4, 3, 2, 1};
        System.out.println(new Solution().maxProfit(prices));
    }
}
