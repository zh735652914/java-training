package leetcode.tooffer;
/*
面试题63. 股票的最大利润
假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？



示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。


限制：

0 <= 数组长度 <= 10^5



注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/

通过次数4,756提交次数7,338
 */

import java.util.Scanner;

//除了暴力，我自己没想到。。。
public class maxProfit {
    static class Solution {
        public int maxProfit(int[] prices) {
            int curMAX = 0, allMAX = 0;
            for (int i = 1; i < prices.length; i++) {
                curMAX = Math.max(0, curMAX + (prices[i] - prices[i - 1]));
                allMAX = Math.max(allMAX, curMAX);
            }
            return allMAX;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] Arr = scanner.nextLine().split(",");
            int[] nums = new int[Arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(Arr[i]);
            }
            System.out.println(new Solution().maxProfit(nums));
        }
    }
}
