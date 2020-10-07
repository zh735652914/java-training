package nowcoder;
/*
 牛客题霸-名企高频面试题
有关阶乘的两个问题1
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：137
 算法知识视频讲解
题目描述
给定一个非负整数N，返回N!结果的末尾为0的数量
示例1
输入
复制
3
输出
复制
0
说明
3!=6
示例2
输入
复制
5
输出
复制
1
说明
5!=120
示例3
输入
复制
1000000000
输出
复制
249999998
备注:
1 \leq N \leq 10^{18}1≤N≤10
18
 */

import java.util.Scanner;

public class thenumberof0 {
    static public class Solution {
        /**
         * the number of 0
         *
         * @param n long长整型 the number
         * @return long长整型
         */
        public long thenumberof0(long n) {
            if (n < 5) {
                return 0;
            }
            return n / 5 + thenumberof0(n / 5);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().thenumberof0(scanner.nextInt()));
        }
    }
}
