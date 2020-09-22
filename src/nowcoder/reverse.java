package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：20206
本题知识点： 数学
 算法知识视频讲解
题目描述
将给出的整数x翻转。
例1:x=123，返回321
例2:x=-123，返回-321

你有思考过下面的这些问题么？
如果整数的最后一位是0，那么输出应该是什么？比如10,100
你注意到翻转后的整数可能溢出吗？假设输入是32位整数，则将翻转10000000003就会溢出，你该怎么处理这样的样例？抛出异常？
这样做很好，但是如果不允许抛出异常呢？这样的话你必须重新设计函数（比如添加一个额外的参数）。
示例1
输入
复制
-123
输出
复制
-321
 */

import java.util.Scanner;

public class reverse {
    static public class Solution {
        /**
         * @param x int整型
         * @return int整型
         */
        public int reverse(int x) {
            boolean flag = false;
            if (x < 0) {
                flag = true;
                x = -x;
            }
            long ans = 0;
            while (x > 0) {
                int cur = x % 10;
                x /= 10;
                ans *= 10;
                ans += cur;
            }
            if (flag) {
                ans = -ans;
            }
            if (ans >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (ans <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int) ans;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().reverse(scanner.nextInt()));
        }
    }
}
