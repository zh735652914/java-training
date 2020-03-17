package LeetCode.ToOffer;
/*
面试题62. 圆圈中最后剩下的数字
0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。



示例 1：

输入: n = 5, m = 3
输出: 3
示例 2：

输入: n = 10, m = 17
输出: 2


限制：

1 <= n <= 10^5
1 <= m <= 10^6
通过次数3,140提交次数5,687
 */

import java.util.Scanner;

//不会写。。。反过来想，这个是真的牛逼。。。
public class lastRemaining {
    static class Solution {
        public int lastRemaining(int n, int m) {
            if (n == 1) return 0;
            return (lastRemaining(n - 1, m) + m) % n;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new Solution().lastRemaining(scanner.nextInt(), scanner.nextInt()));
    }
}
