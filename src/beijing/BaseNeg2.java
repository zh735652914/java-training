package beijing;
/*
https://leetcode.cn/problems/convert-to-base-2/
 */

/**
 * @author zhouhao
 * @date 2023/4/6 21:39
 */
public class BaseNeg2 {
    // 这个题我都不会了，要看看
    static class Solution {
        public String baseNeg2(int n) {
            if (n == 0) {
                return "0";
            }
            StringBuilder ans = new StringBuilder();
            while (n != 0) {
                int remain = n & 1;
                if (remain == 0) {
                    ans.insert(0, "0");
                } else {
                    ans.insert(0, "1");
                }
                n -= remain;
                n /= -2;
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Solution().baseNeg2(n));
    }
}
