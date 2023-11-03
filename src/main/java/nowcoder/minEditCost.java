package nowcoder;
/*
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：3224
本题知识点： 字符串 动态规划
 算法知识视频讲解
题目描述
给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。
示例1
输入
复制
"abc","adc",5,3,2
输出
复制
2
示例2
输入
复制
"abc","adc",5,3,100
输出
复制
8
备注:
1 \leq |str_1|, |str_2| \leq 50001≤∣str
1
​
 ∣,∣str
2
​
 ∣≤5000
1 \leq ic, dc, rc \leq 100001≤ic,dc,rc≤10000
 */

public class minEditCost {
    static public class Solution0 {
        /**
         * min edit cost
         *
         * @param str1 string字符串 the string
         * @param str2 string字符串 the string
         * @param ic   int整型 insert cost
         * @param dc   int整型 delete cost
         * @param rc   int整型 replace cost
         * @return int整型
         */
        int ic, dc, rc;
        int minCost;

        public int minEditCost(String str1, String str2, int ic, int dc, int rc) {
            this.ic = ic;
            this.dc = dc;
            this.rc = rc;
            minCost = Integer.MAX_VALUE;
            dfs(str1, str2, 0, 0);
            return minCost;
        }

        private void dfs(String str1, String str2, int cost, int index) {
            if (str1.equals(str2)) {
                minCost = Math.min(cost, minCost);
            }
            StringBuilder stringBuilder = new StringBuilder(str1);
            StringBuilder tmp = new StringBuilder(str1);
            for (int i = index; i < str1.length() && i < str2.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    String tmp1 = stringBuilder.insert(i, str2.charAt(i)).toString();
                    dfs(tmp1, str2, cost + ic, index + 1);
                    stringBuilder = tmp;
                    String tmp2 = stringBuilder.deleteCharAt(i).toString();
                    dfs(tmp2, str2, cost + dc, index + 1);
                    stringBuilder = tmp;
                    String tmp3 = stringBuilder.replace(i, i + 1, String.valueOf(str2.charAt(i))).toString();
                    dfs(tmp3, str2, cost + rc, index + 1);
                }
            }
        }
    }

    static public class Solution {
        public int minEditCost(String str1, String str2, int ic, int dc, int rc) {
            int[][] dp = new int[str1.length() + 1][str2.length() + 1];
            for (int i = 0; i <= str1.length(); i++) {
                dp[i][0] = i * dc;
            }
            for (int i = 0; i <= str2.length(); i++) {
                dp[0][i] = i * ic;
            }
            for (int i = 1; i <= str1.length(); i++) {
                for (int j = 1; j <= str2.length(); j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int insert = dp[i][j - 1] + ic;
                        int del = dp[i - 1][j] + dc;
                        int replace = dp[i - 1][j - 1] + rc;
                        dp[i][j] = Math.min(insert, Math.min(del, replace));
                    }
                }
            }
            return dp[str1.length()][str2.length()];
        }
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "adc";
        int ic = 5;
        int dc = 3;
        int rc = 100;
        System.out.println(new Solution().minEditCost(str1, str2, ic, dc, rc));
    }
}
