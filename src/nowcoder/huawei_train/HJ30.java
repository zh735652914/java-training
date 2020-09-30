package nowcoder.huawei_train;
/*
 华为机试
字符串合并处理 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：72472
本题知识点： 字符串 排序
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
按照指定规则对输入的字符串进行处理。

详细描述：

将输入的两个字符串合并。

对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。

对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。


举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”

接口设计及说明：
功能:字符串处理

输入:两个字符串,需要异常处理

输出:合并处理后的字符串，具体要求参考文档

返回:无
void ProcessString(char* str1,char *str2,char * strOutput)

{

}
输入描述:
输入两个字符串

输出描述:
输出转化后的结果

示例1
输入
复制
dec fab
输出
复制
5D37BF
 */

import java.util.Arrays;
import java.util.Scanner;

public class HJ30 {
    public String solution(String s1, String s2) {
        String s = merge(s1, s2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            stringBuilder.append(reverse(x));
        }
        return stringBuilder.toString();
    }

    private char reverse(char x) {
        if (!(x >= 'a' && x <= 'f' || x >= 'A' && x <= 'F' || x >= '0' && x <= '9')) {
            return x;
        }
        String bit = "";
        if (x >= 'a' && x <= 'f' || x >= 'A' && x <= 'F') {
            x = Character.toUpperCase(x);
            bit = Integer.toBinaryString(10 + x - 'A');

        }
        if (x >= '0' && x <= '9') {
            bit = Integer.toBinaryString(x - '0');
        }
        int value = 0;
        int len = bit.length();
        for (int i = 0; i < 4 - len; i++) {
            bit = '0' + bit;
        }
        for (int i = bit.length() - 1; i >= 0; i--) {
            value *= 2;
            value += bit.charAt(i) - '0';
        }
        if (value >= 10) {
            return (char) ('A' + value - 10);
        } else {
            return Integer.toString(value).charAt(0);
        }
    }


    private String merge(String s1, String s2) {
        String s = s1 + s2;
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                even.append(s.charAt(i));
            } else {
                odd.append(s.charAt(i));
            }
        }
        String s_odd = odd.toString();
        String s_even = even.toString();
        char[] ODD = s_odd.toCharArray();
        Arrays.sort(ODD);
        char[] EVEN = s_even.toCharArray();
        Arrays.sort(EVEN);
        StringBuilder stringBuilder = new StringBuilder();
        int index_odd = 0, index_even = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 1) {
                stringBuilder.append(ODD[index_odd++]);
            } else {
                stringBuilder.append(EVEN[index_even++]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] S = scanner.nextLine().split(" ");
            System.out.println(new HJ30().solution(S[0], S[1]));
        }
    }
}
