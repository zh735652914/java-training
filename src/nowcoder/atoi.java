package nowcoder;
/*
 牛客题霸-名企高频面试题
将字符串转化为整数 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：21322
本题知识点： 字符串
 算法知识视频讲解
题目描述
实现函数 atoi 。函数的功能为将字符串转化为整数
提示：仔细思考所有可能的输入情况。这个问题没有给出输入的限制，你需要自己考虑所有可能的情况。



示例1
输入
复制
"123"
输出
复制
123
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.Scanner;

public class atoi {
    static public class Solution {
        /**
         * @param str string字符串
         * @return int整型
         */
        public int atoi(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            boolean flag = false;
            boolean get = false;
            int ans = 0;
            for (int i = 0; i < str.length(); i++) {
                char x = str.charAt(i);
                if (x == ' ') {
                    continue;
                }
                if (x == '-' || x == '+') {
                    if (get) {
                        break;
                    } else {
                        flag = x == '-';
                        get = true;
                    }
                    continue;
                }
                if (x < '0' || x > '9') {
                    break;
                } else {
                    if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (x - '7') > 0)) {
                        return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                    ans *= 10;
                    ans += x - '0';
                }
            }
            return flag ? -ans : ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().atoi(scanner.nextLine()));
        }
    }
}
