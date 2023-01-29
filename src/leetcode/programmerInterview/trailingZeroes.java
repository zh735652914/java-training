package leetcode.programmerInterview;
/*
面试题 16.05. 阶乘尾数
设计一个算法，算出 n 阶乘有多少个尾随零。

示例 1:

输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。
示例 2:

输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.
说明: 你算法的时间复杂度应为 O(log n) 。

通过次数3,617提交次数7,683
 */

import java.util.Scanner;

//自己不会写，看了答案，感觉自己还是差很多
public class trailingZeroes {
    static class Solution {
        public int trailingZeroes(int n) {
            int ans = 0;
            while (n >= 5) {
                n /= 5;
                ans += n;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().trailingZeroes(scanner.nextInt()));
        }
    }
}
