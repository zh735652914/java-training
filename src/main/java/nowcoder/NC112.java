package nowcoder;
/*
 牛客题霸-名企高频面试题
进制转换
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：2933
本题知识点： 位运算
 算法知识视频讲解
题目描述
给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
示例1
输入
复制
7,2
输出
复制
"111"
备注:
M是32位整数，2<=N<=16.
 */

public class NC112 {
    static public class Solution {
        /**
         * 进制转换
         *
         * @param M int整型 给定整数
         * @param N int整型 转换到的进制
         * @return string字符串
         */
        public String solve(int M, int N) {
            StringBuilder stringBuilder = new StringBuilder();
            boolean flag = false;
            if (M < 0) {
                flag = true;
                M = -M;
            }
            while (M > 0) {
                int res = M % N;
                M /= N;
                if (res < 10) {
                    stringBuilder.append(res);
                } else {
                    char x = (char) ('A' + res - 10);
                    stringBuilder.append(x);
                }
            }
            if (flag) {
                stringBuilder.append('-');
            }
            return stringBuilder.reverse().toString();
        }
    }

    public static void main(String[] args) {
        int M = -4, N = 3;
        System.out.println(new Solution().solve(M, N));
    }
}
