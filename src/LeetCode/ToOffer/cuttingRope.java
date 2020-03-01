package LeetCode.ToOffer;
/*
面试题14- I. 剪绳子
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：

2 <= n <= 58
注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/

通过次数3,312提交次数5,898
 */

import java.util.Scanner;

//第一次遇到这种题，不会写，看了讨论发现有点意思
public class cuttingRope {
    static class Solution {
        public int cuttingRope(int n) {
            if (n == 2) return 1;
            if (n == 3) return 2;
            int ans = 1;
            while (n > 0) {
                if (n == 1) {
                    ans /= 3;
                    n += 1;
                    ans *= 2;
                } else if (n < 3) {
                    n -= 2;
                    ans *= 2;
                } else {
                    n -= 3;
                    ans *= 3;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().cuttingRope(scanner.nextInt()));
        }
    }
}
