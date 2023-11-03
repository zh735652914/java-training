package nowcoder;
/*
 牛客题霸-名企高频面试题
股票交易的最大收益（二）
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 256M，其他语言512M 热度指数：98
 算法知识视频讲解
题目描述
假定你知道某只股票每一天价格的变动。
你最多可以同时持有一只股票。但你最多只能进行两次交易（一次买进和一次卖出记为一次交易。买进和卖出均无手续费）。
请设计一个函数，计算你所能获得的最大收益。
示例1
输入
复制
[8,9,3,5,1,3]
输出
复制
4
说明
第三天买进，第四天卖出，第五天买进，第六天卖出。总收益为4。
备注:
总天数不大于200000。保证股票每一天的价格在[1,100]范围内。
 */


//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/wu-chong-shi-xian-xiang-xi-tu-jie-123mai-mai-gu-pi/

public class NC135 {
    static public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 两次交易所能获得的最大收益
         *
         * @param prices int整型一维数组 股票每一天的价格
         * @return int整型
         */
        public int maxProfit(int[] prices) {
            int[] first = new int[prices.length];
            int[] second = new int[prices.length];
            //每天的价格减去最小买入
            int min = prices[0];
            for (int i = 1; i < first.length; i++) {
                min = Math.min(min, prices[i]);
                first[i] = Math.max(first[i - 1], prices[i] - min);
            }
            //最大卖出减去每天的价格
            int max = prices[prices.length - 1];
            for (int i = prices.length - 2; i >= 0; i--) {
                max = Math.max(max, prices[i]);
                second[i] = Math.max(second[i + 1], max - prices[i]);
            }
            int ans = 0;
            for (int i = 0; i < prices.length; i++) {
                ans = Math.max(ans, first[i] + second[i]);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] prices = {8, 9, 3, 5, 1, 3};
        System.out.println(new Solution().maxProfit(prices));
    }
}
