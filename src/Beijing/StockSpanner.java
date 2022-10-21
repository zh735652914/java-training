package Beijing;
/*
https://leetcode.cn/problems/online-stock-span/
 */

import java.util.Stack;

// 自己没想出来
public class StockSpanner {

    private final Stack<int[]> stack;
    private int index;

    public StockSpanner() {
        stack = new Stack<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        index = -1;
    }

    public int next(int price) {
        index++;
        while (stack.peek()[1] <= price) {
            stack.pop();
        }
        int ans = index - stack.peek()[0];
        stack.push(new int[]{index, price});
        return ans;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));  // return 6
    }
}
