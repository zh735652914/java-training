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
    char[] A = {'a', 'b', 'c'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        abc A = new abc();
        int ans = A.backtrace(S, 0, 0, 0);
        System.out.println(ans);
    }


    public int backtrace(String S, int ans, int pos, int x) {
        if (S.length() < 3) return 0;
        for (int i = pos; i < S.length(); i++) {
            if (S.charAt(i) == A[x]) {
                x++;
                if (x < 3) {
//                    return backtrace(S, ans, ++i, x) + backtrace(S, ans, i + 2, x);
                    ans = backtrace(S, ans, i + 2, x);
                } else {
                    x = 0;
//                    return backtrace(S, ++ans, ++i, x) + backtrace(S, ++ans, i + 2, x);
                    ans = backtrace(S, ++ans, i + 2, x);
                }
            }
        }
        return ans;
    }
}
