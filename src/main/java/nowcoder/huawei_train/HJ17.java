package nowcoder.huawei_train;
/*
 华为机试
坐标移动 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：302918
本题知识点： 字符串
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。

输入：

合法坐标为A(或者D或者W或者S) + 数字（两位以内）

坐标之间以;分隔。

非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。

下面是一个简单的例子 如：

A10;S20;W10;D30;X;A1A;B10A11;;A10;

处理过程：

起点（0,0）

+   A10   =  （-10,0）

+   S20   =  (-10,-20)

+   W10  =  (-10,-10)

+   D30  =  (20,-10)

+   x    =  无效

+   A1A   =  无效

+   B10A11   =  无效

+  一个空 不影响

+   A10  =  (10,-10)

结果 （10， -10）

注意请处理多组输入输出

输入描述:
一行字符串

输出描述:
最终坐标，以,分隔

示例1
输入
复制
A10;S20;W10;D30;X;A1A;B10A11;;A10;
输出
复制
10,-10
 */

import java.util.Scanner;

public class HJ17 {
    public void solution(String s) {
        s = s.toUpperCase();
        String[] op = s.split(";");
        int[] pos = new int[2];
        for (int i = 0; i < op.length; i++) {
            pos = go(pos, i, op);
        }
        System.out.println(pos[0] + "," + pos[1]);
    }

    private int[] go(int[] pos, int index, String[] op) {
        if (index >= op.length || op[index] == null || op[index].length() > 3 || op[index].length() < 2) {
            return pos;
        }
        String s = op[index];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return pos;
            }
        }
        char where = s.charAt(0);
        int len = Integer.parseInt(s.substring(1));
        switch (where) {
            case 'A':
                pos[0] -= len;
                break;
            case 'S':
                pos[1] -= len;
                break;
            case 'W':
                pos[1] += len;
                break;
            case 'D':
                pos[0] += len;
                break;
            default:
                break;
        }
        return pos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            new HJ17().solution(scanner.nextLine());
        }
    }
}
