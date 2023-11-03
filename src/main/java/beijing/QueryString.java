package beijing;
/*
https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/
 */

/**
 * @author zhouhao
 * @date 2023/5/11 13:24
 */
public class QueryString {
    static class Solution {
        public boolean queryString(String s, int n) {
            for (int i = 1; i <= n; i++) {
                if (!s.contains(Integer.toBinaryString(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "0110";
        int n = 3;
        System.out.println(new Solution().queryString(s, n));
    }
}
