package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：695986
本题知识点： 递归
 算法知识视频讲解
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 */

import java.util.Scanner;

public class JumpFloor {
    static public class Solution {
        public int JumpFloor(int target) {
            if (target == 1) {
                return 1;
            }
            int[] dp = new int[target + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= target; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[target];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().JumpFloor(scanner.nextInt()));
        }
    }
}
