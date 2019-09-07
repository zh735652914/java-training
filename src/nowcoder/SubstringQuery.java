package nowcoder;

import java.util.Scanner;
/*
不通过
您的代码已保存
运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
case通过率为38.10%


看已经别人通过的代码，好像要用DP
 */
/*
链接：https://ac.nowcoder.com/acm/contest/1083/B
来源：牛客网

题目描述
给出一个长度为n的字符串s和q个查询。对于每一个查询，会输入一个字符串t，你需要判断这个字符串t是不是s的子串。子串的定义就是存在任意下标a<b<c<d<e，那么”s[a]s[b]s[c]s[d]s[e]”就构成s的一个子串。如”abc”的子串有”a”、”b”、”c”、”ab”、”ac”、”bc”、”abc”。
输入描述:
第一行两个数n，q。1<=n，q<=1e5。

第二行一个长度为n的字符串s,所有字符都为小写拉丁字符。

接下来q行每行一个字符串t。1<=|t|<=50。
输出描述:
对于每个查询，如果t是s的字串，输出”YES”,否则输出”NO”。每个答案占一行。
示例1
输入
8 4
ababcbaa
abac
accb
aaaa
abcba

输出
YES
NO
YES
YES
 */
public class SubstringQuery {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        int n = SC.nextInt();
        int q = SC.nextInt();
        SC.nextLine();
        String S = SC.nextLine();
        while (q > 0) {
            q--;
            String X = SC.nextLine();
            int pos = 0;
            for (int i = 0; i < S.length(); i++) {
                if(X.charAt(pos) == S.charAt(i)){
                    pos++;
                }
                if (pos >= X.length()) {
                    System.out.println("YES");
                    break;
                }
            }
            if(pos<X.length())System.out.println("NO");
        }
    }
}
