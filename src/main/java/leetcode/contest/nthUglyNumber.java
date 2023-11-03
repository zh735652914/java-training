package leetcode.contest;

/*
请你帮忙设计一个程序，用来找出第 n 个丑数。

丑数是可以被 a 或 b 或 c 整除的正整数。



示例 1：

输入：n = 3, a = 2, b = 3, c = 5
输出：4
解释：The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
示例 2：

输入：n = 4, a = 2, b = 3, c = 4
输出：6
解释：丑数序列为 2, 3, 4, 6, 8, 9, 12... 其中第 4 个是 6。
示例 3：

输入：n = 5, a = 2, b = 11, c = 13
输出：10
解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
示例 4：

输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
输出：1999999984


提示：

1 <= n, a, b, c <= 10^9
1 <= a * b * c <= 10^18
本题结果在 [1, 2 * 10^9] 的范围内
 */

//不通过！！！！！！！！！！
class nthUglyNumberSolution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int count = 0, ans = 0;
        int p = 0, q = 0, r = 0;
        while (count < n) {
            int A = a * (p + 1), B = b * (q + 1), C = c * (r + 1);
            int tmp = Math.min(Math.min(A, B), C);
            if (tmp == A) p++;
            if (tmp == B) q++;
            if (tmp == C) r++;
            ans = tmp;
            count++;
        }
        return ans;
    }
//public int nthUglyNumber(int n, int a, int b, int c) {
//    int count = 0, ans = 0;
//    while (count < n) {
//        ans++;
//        if (ans % a == 0 || ans % b == 0 || ans % c == 0) count++;
//    }
//    return ans;
//}
}

public class nthUglyNumber {
    public static void main(String[] args) {
//        int n = 4, a = 2, b = 3, c = 4;
        int n = 1000000000, a = 2, b = 217983653, c = 336916467;
        nthUglyNumberSolution NUMS = new nthUglyNumberSolution();
        System.out.println(NUMS.nthUglyNumber(n, a, b, c));
    }
}
