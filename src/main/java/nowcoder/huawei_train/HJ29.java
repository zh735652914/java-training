package nowcoder.huawei_train;
/*
 华为机试
字符串加解密 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：88617
本题知识点： 字符串
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
1、对输入的字符串进行加解密，并输出。

2加密方法为：

当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；

当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；

其他字符不做变化。

3、解密方法为加密的逆过程。



接口描述：

    实现接口，每个接口实现1个基本操作：

void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出

说明：

1、字符串以\0结尾。

2、字符串最长100个字符。



int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出

说明：

1、字符串以\0结尾。

    2、字符串最长100个字符。







输入描述:
输入说明
输入一串要加密的密码
输入一串加过密的密码

输出描述:
输出说明
输出加密后的字符
输出解密后的字符

示例1
输入
复制
abcdefg
BCDEFGH
输出
复制
BCDEFGH
abcdefg
 */

import java.util.Scanner;


public class HJ29 {
    interface encrypt {
        void Encrypt(char[] aucPassword, char[] aucResult);

        void unEncrypt(char[] result, char[] password);
    }

    static class solution implements encrypt {
        solution(String s1, String s2) {
            char[] aucPassword = s1.toCharArray();
            char[] aucResult = new char[s1.length()];
            char[] result = s2.toCharArray();
            char[] password = new char[s2.length()];
            Encrypt(aucPassword, aucResult);
            unEncrypt(result, password);
            for (char x : aucResult) {
                System.out.print(x);
            }
            System.out.println();
            for (char x : password) {
                System.out.print(x);
            }
            System.out.println();
        }

        @Override
        public void Encrypt(char[] aucPassword, char[] aucResult) {
            for (int i = 0; i < aucPassword.length; i++) {
                char x = aucPassword[i];
                if (x >= '0' && x <= '9') {
                    if (x == '9') {
                        aucResult[i] = '0';
                    } else {
                        aucResult[i] = (char) (x + 1);
                    }
                } else if (x >= 'a' && x <= 'z') {
                    x = Character.toUpperCase(x);
                    if (x == 'Z') {
                        aucResult[i] = 'A';
                    } else {
                        aucResult[i] = (char) (x + 1);
                    }
                } else if (x >= 'A' && x <= 'Z') {
                    x = Character.toLowerCase(x);
                    aucResult[i] = x == 'z' ? 'a' : (char) (x + 1);
                } else {
                    aucResult[i] = aucPassword[i];
                }
            }
        }

        @Override
        public void unEncrypt(char[] result, char[] password) {
            for (int i = 0; i < result.length; i++) {
                char x = result[i];
                if (x >= '0' && x <= '9') {
                    password[i] = x == '0' ? '9' : (char) (x - 1);
                } else if (x >= 'a' && x <= 'z') {
                    x = Character.toUpperCase(x);
                    password[i] = x == 'A' ? 'Z' : (char) (x - 1);
                } else if (x >= 'A' && x <= 'Z') {
                    x = Character.toLowerCase(x);
                    password[i] = x == 'a' ? 'z' : (char) (x - 1);
                } else {
                    password[i] = x;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            new solution(scanner.nextLine(), scanner.nextLine());
        }
    }
}
