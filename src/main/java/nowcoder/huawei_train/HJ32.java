package nowcoder.huawei_train;
/*
 华为机试
字符串运用-密码截取 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：84310
本题知识点： 字符串
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，
你能帮Catcher找出最长的有效密码串吗？



输入描述:
输入一个字符串

输出描述:
返回有效密码串的最大长度

示例1
输入
复制
ABBA
输出
复制
4
 */

import java.util.Scanner;

public class HJ32 {
    static public int solution(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, Math.max(go(s, i, i), go(s, i, i + 1)));
        }
        return max;
    }

    static private int go(String s, int left, int right) {
        if (right >= s.length() || left < 0) {
            return 1;
        }
        int len = left == right ? 1 : 0;
        if (left == right) {
            left--;
            right++;
        }
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left--) == s.charAt(right++)) {
                len += 2;
            } else {
                return len;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(solution(scanner.nextLine()));
        }
    }
}
