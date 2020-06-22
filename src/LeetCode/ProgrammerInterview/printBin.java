package LeetCode.ProgrammerInterview;
/*
面试题 05.02. 二进制数转字符串
二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。

示例1:

 输入：0.625
 输出："0.101"
示例2:

 输入：0.1
 输出："ERROR"
 提示：0.1无法被二进制准确表示
提示：

32位包括输出中的"0."这两位。
通过次数1,840提交次数3,105
 */

import java.util.Scanner;

//自己写的、
public class printBin {
    static class Solution {
        public String printBin(double num) {
            if (num > 1 || num < 0) return "ERROR";
            StringBuilder ans = new StringBuilder("0.");
            for (int i = 1; i < 32; i++) {
                if (num == 0) return ans.toString();
                double tmp = Math.pow(2, -i);
                if (tmp <= num) {
                    num -= tmp;
                    ans.append("1");
                } else {
                    ans.append("0");
                }
            }
            return "ERROR";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().printBin(scanner.nextDouble()));
        }
    }
}
