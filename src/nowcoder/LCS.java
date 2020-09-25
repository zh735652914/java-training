package nowcoder;
/*
 牛客题霸-名企高频面试题
最长公共子序列
时间限制：C/C++ 3秒，其他语言6秒 空间限制：C/C++ 256M，其他语言512M 热度指数：2405
本题知识点： 动态规划
 算法知识视频讲解
题目描述
给定两个字符串str1和str2，输出连个字符串的最长公共子序列。如过最长公共子序列为空，则输出-1。
示例1
输入
复制
"1A2C3D4B56","B1D23CA45B6A"
输出
复制
"123456"
说明
"123456"和“12C4B6”都是最长公共子序列，任意输出一个。
备注:
1 \leq |str_1|, |str_2| \leq 5\,0001≤∣str
1
​
 ∣,∣str
2
​
 ∣≤5000
 */

public class LCS {
    static public class Solution {
        /**
         * longest common subsequence
         *
         * @param s1 string字符串 the string
         * @param s2 string字符串 the string
         * @return string字符串
         */
        public String LCS(String s1, String s2) {
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }


            int left = s1.length();
            int right = s2.length();
            while (left > 0 && right > 0) {
                if (s1.charAt(left - 1) == s2.charAt(right - 1)) {
                    stringBuilder.append(s1.charAt(left - 1));
                    left--;
                    right--;
                } else {
                    if (dp[left - 1][right] > dp[left][right - 1]) {
                        left--;
                    } else if (dp[left][right - 1] > dp[left - 1][right]) {
                        right--;
                    } else {
                        left--;
                    }
                }
            }

            System.out.println(dp[s1.length()][s2.length()]);
            return stringBuilder.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23CA45B6A";
        System.out.println(new Solution().LCS(s1, s2));
    }
}
