package leetcode.tooffer;
/*
面试题43. 1～n整数中1出现的次数
输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。



示例 1：

输入：n = 12
输出：5
示例 2：

输入：n = 13
输出：6


限制：

1 <= n < 2^31
注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/

通过次数1,433提交次数3,232
 */

import java.util.Scanner;

//不会写。。。看了Discuss，感觉自己依旧是智障
public class countDigitOne {
    static class Solution {
        public int countDigitOne(int n) {
            int ans = 0;
            //这里类型必须是long，否则会溢出
            for (long m = 1; m <= n; m *= 10) {
                ans += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().countDigitOne(scanner.nextInt()));
        }
    }
}
