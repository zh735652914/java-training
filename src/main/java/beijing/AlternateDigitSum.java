package beijing;
/*
https://leetcode.cn/problems/alternating-digit-sum/
 */

/**
 * @author zhouhao
 * @date 2023/7/12 12:29
 */
public class AlternateDigitSum {
    // 很简单的题目
    static class Solution {
        public int alternateDigitSum(int n) {
            String str = String.valueOf(n);
            int ans = 0;
            for (int i = 0; i < str.length(); i++) {
                ans += (str.charAt(i) - '0') * ((i & 1) == 0 ? 1 : -1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 521;
        System.out.println(new Solution().alternateDigitSum(n));
    }
}
