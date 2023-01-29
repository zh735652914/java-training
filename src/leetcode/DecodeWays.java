package leetcode;
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

//自己写的，我太难了！！！！！！！！！！！！！！！
class MyDecodeWaysSolution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        return bracktrack(s, s.length() - 1, false, false);
    }

    private int bracktrack(String s, int pos, boolean last, boolean flag) {
        if (flag) return 0;
        if (pos == 0) {
            if (s.charAt(pos) == '0') return 0;
            return 1;
        }
        int a = s.charAt(pos - 1) - '0', b = s.charAt(pos) - '0';
        if ((a == 0 || a > 2) && b == 0) flag = true;
        if (pos == 1) {
            if (!(a == 1 || a == 2) && b == 0) return 0;
            if (b == 0) return 1;
            if (a > 2 || (a == 2 && b >= 7)) return 1;
            return 2;
        }
        if (b == 0) {
//            count++;
            if (last) flag = true;
            last = true;
            if (a == 1 || a == 2) return bracktrack(s, pos - 2, false, flag);
            return bracktrack(s, pos - 1, last, flag);
        }
        if (b >= 7) {
            if (a < 2 && a > 0) {
                return bracktrack(s, pos - 2, false, false) + bracktrack(s, pos - 1, false, flag);
            } else if (a == 0) {
//                count++;
                return bracktrack(s, pos - 1, false, false);
            } else {
                return bracktrack(s, pos - 1, false, false);
            }
        } else {
            if (a > 2 || a <= 0) {
//                if (a == 0) count++;
//                return bracktrack(s, pos - 1, count);
                return bracktrack(s, pos - 1, false, false);
            } else {
                return bracktrack(s, pos - 1, false, false) + bracktrack(s, pos - 2, false, false);
            }
        }
    }
}

//Discuss中别人写的dp
class DecodeWaysSolution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first > 0 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}

public class DecodeWays {
    public static void main(String[] args) {
        String s = "509";
//        String s = "101010";
//        String s = "7206";
//        System.out.println("07= " + Integer.valueOf(s.substring(0, 2)));
        DecodeWaysSolution DW = new DecodeWaysSolution();
        System.out.println(DW.numDecodings(s));
    }
}
