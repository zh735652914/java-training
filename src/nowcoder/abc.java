package nowcoder;
/*
链接：https://ac.nowcoder.com/acm/contest/1083/A
来源：牛客网

给出一个字符串s,你需要做的是统计s中子串”abc”的个数。子串的定义就是存在任意下标a<b<c，那么”s[a]s[b]s[c]”就构成s的一个子串。如”abc”的子串有”a”、”b”、”c”、”ab”、”ac”、”bc”、”abc”。
输入描述:
一个字符串s。保证输入只包含小写拉丁字符。
输出描述:
一个整数表示s中子串”abc”的个数。
示例1
输入
abcabc

输出
4
 */

import java.util.Scanner;

public class abc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        abc A = new abc();
        long ans = A.Solution(S);
        System.out.println(ans);
    }

    private long Solution(String S) {
        long A = 0, AB = 0, ABC = 0;
        for (int i = 0; i <S.length(); i++) {
            if(S.charAt(i)=='a'){
                A++;
            }else if(S.charAt(i)=='b'){
                AB=AB+A;
            }else if (S.charAt(i)=='c'){
                ABC=ABC+AB;
            }
        }
        return ABC;
    }
}
