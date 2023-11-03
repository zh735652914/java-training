package leetcode.tooffer;
/*
面试题46. 把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"


提示：

0 <= num < 231
通过次数2,549提交次数5,142
 */

import java.util.Scanner;

//不难，一开始没想到用dp写
public class translateNum {
    static class Solution {
        public int translateNum(int num) {
            String str = String.valueOf(num);
            if (str.length() < 2) return 1;
            int[] dp = new int[str.length()];
            dp[0] = 1;
            dp[1] = dp[0] + (Integer.parseInt(str.substring(0, 2)) < 26 ? 1 : 0);
//            if (Integer.parseInt(str.substring(0, 2)) < 26) {
//                dp[1] = dp[0] + 1;
//            } else {
//                dp[1] = dp[0];
//            }
            for (int i = 2; i < str.length(); i++) {
                if (str.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 1] + (Integer.parseInt(str.substring(i - 1, i + 1)) < 26 ? dp[i - 2] : 0);
                }
            }
            return dp[str.length() - 1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().translateNum(scanner.nextInt()));
        }
    }
}
