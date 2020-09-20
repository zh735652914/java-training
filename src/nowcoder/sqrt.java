package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：34521
本题知识点： 数学 二分
 算法知识视频讲解
题目描述
实现函数 int sqrt(int x).
计算并返回x的平方根
示例1
输入
复制
2
输出
复制
1
 */

import java.util.Scanner;

public class sqrt {
    static public class Solution {
        /**
         * @param x int整型
         * @return int整型
         */
        public int sqrt(int x) {
            long start = 1, end = x, mid = 0, ans = 0;
            while (start <= end) {
                mid = (start + end) / 2;
                long tmp = mid * mid;
                if (tmp == x) {
                    return (int) mid;
                } else if (tmp < x) {
                    start = mid + 1;
                    ans = mid;
                } else {
                    end = mid - 1;
                }
            }
            return (int) ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().sqrt(scanner.nextInt()));
        }
    }
}
