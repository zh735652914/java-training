package beijing;
/*
https://leetcode.cn/problems/count-number-of-homogenous-substrings/
 */

/**
 * @author zhouhao
 * @date 2022/12/26 12:37
 */
public class CountHomogenous {
    // 看了解析才会写的
    static class Solution {
        public int countHomogenous(String s) {
            char pre = s.charAt(0);
            int count = 0;
            long ans = 0;
            int MOD = 1000000007;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == pre) {
                    count++;
                } else {
                    ans += (long) (1 + count) * count / 2;
                    ans %= MOD;
                    count = 1;
                    pre = s.charAt(i);
                }
            }
            ans += (long) (1 + count) * count / 2;
            ans %= MOD;
            return (int) ans;
        }
    }

    public static void main(String[] args) {
        String s = "abbcccaa";
        System.out.println(new Solution().countHomogenous(s));
    }
}
