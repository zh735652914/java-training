package LeetCode.ToOffer;
/*
面试题64. 求1+2+…+n
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。



示例 1：

输入: n = 3
输出: 6
示例 2：

输入: n = 9
输出: 45


限制：

1 <= n <= 10000
通过次数6,813提交次数8,012
 */

import java.util.Scanner;

//不会。。。
public class sumNums {
    static class Solution {
        public int sumNums(int n) {
            int sum = n;
            boolean flag = n > 0 && (sum += sumNums(n - 1)) > 0;
            return sum;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().sumNums(scanner.nextInt()));
        }
    }
}
