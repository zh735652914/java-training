package nowcoder;
/*
 牛客题霸-名企高频面试题
字符串变形
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：7703
本题知识点： 字符串
 算法知识视频讲解
题目描述
对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。首先这个字符串中包含着一些空格，就像"Hello World"一样，
然后我们要做的是把着个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。比如"Hello World"变形后就变成了"wORLD hELLO"。

输入描述:
给定一个字符串s以及它的长度n(1≤n≤500)
输出描述:
请返回变形后的字符串。题目保证给定的字符串均由大小写字母和空格构成。
示例1
输入
复制
"This is a sample",16
输出
复制
"SAMPLE A IS tHIS"
 */

public class trans {

    static public class Transform {
        public String trans(String s, int n) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] S = s.toCharArray();
            for (int i = S.length - 1; i >= 0; i--) {
                if (S[i] == ' ') {
                    stringBuilder.append(' ');
                    continue;
                }
                int start = i;
                while (start >= 0 && S[start] != ' ') {
                    if (S[start] >= 'a' && S[start] <= 'z') {
                        S[start] = Character.toUpperCase(S[start]);
                    } else {
                        S[start] = Character.toLowerCase(S[start]);
                    }
                    start--;
                }
                start++;
                for (int j = start; j <= i; j++) {
                    stringBuilder.append(S[j]);
                }
                i = start;
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String s = "This is a sample";
        int n = 16;
        System.out.println(new Transform().trans(s, n));
    }
}
