package nowcoder.huawei_train;
/*
 华为机试
整数与IP地址间的转换 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：67711
本题知识点： 字符串
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
一个长整数。
举例：一个ip地址为10.0.3.193
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001
组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。



的每段可以看成是一个0-255的整数，需要对IP地址进行校验







输入描述:
输入
1 输入IP地址
2 输入10进制型的IP地址

输出描述:
输出
1 输出转换成10进制的IP地址
2 输出转换后的IP地址

示例1
输入
复制
10.0.3.193
167969729
输出
复制
167773121
10.3.3.193
 */

import java.util.Scanner;

public class HJ33 {

    private final int N = 4;

    public String convert(String str) {
        // ipv4 -> int
        if (str.contains(".")) {
            String[] fields = str.split("\\.");
            long result = 0;
            for (int i = 0; i < N; i++) {
                result = result * 256 + Integer.parseInt(fields[i]);
            }
            return String.valueOf(result);
        }
        // int -> ipv4
        else {
            long ipv4 = Long.parseLong(str);
            String result = "";
            for (int i = 0; i < N; i++) {
                result = ipv4 % 256 + "." + result;
                ipv4 /= 256;
            }
            return result.substring(0, result.length() - 1);
        }
    }

    public static void main(String[] args) {
        HJ33 solution = new HJ33();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            String res = solution.convert(str);
            System.out.println(res);
        }
    }


//    public void solution(String s, int num) {
//        String[] S = s.split("\\.");
//        int ipToNum = toNum(S);
//        System.out.println(ipToNum);
//        String nimToIp = toIp(num);
//        System.out.println(nimToIp.substring(0, nimToIp.length() - 1));
//    }
//
//    private String toIp(int num) {
//        String S = Integer.toBinaryString(num);
//        if (S.length() < 32) {
//            StringBuilder tmp = new StringBuilder();
//            for (int i = 0; i < 32 - S.length(); i++) {
//                tmp.append('0');
//            }
//            S = tmp.toString() + S;
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < 4; i++) {
//            String x = S.substring(i * 8, (i + 1) * 8);
//            int value = 0;
//            for (int j = 0; j < x.length(); j++) {
//                value *= 2;
//                value += x.charAt(j) - '0';
//            }
//            stringBuilder.append(value).append('.');
//        }
//        return stringBuilder.toString();
//    }
//
//
//    private int toNum(String[] nums) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (String num : nums) {
//            stringBuilder.append(mkStr(num));
//        }
//        String S = stringBuilder.toString();
//        int ans = 0;
//        for (int i = 0; i < S.length(); i++) {
//            ans *= 2;
//            ans += S.charAt(i) - '0';
//        }
//        return ans;
//    }
//
//    private String mkStr(String num) {
//        String x = Integer.toBinaryString(Integer.parseInt(num));
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < 8; i++) {
//            if (i < x.length()) {
//                stringBuilder.append(x.charAt(x.length() - i - 1));
//            } else {
//                stringBuilder.append('0');
//            }
//        }
//        return stringBuilder.reverse().toString();
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            new HJ33().solution(scanner.nextLine(), scanner.nextInt());
//        }
//    }
}
