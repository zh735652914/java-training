package Beijing;
/*
https://leetcode.cn/problems/maximum-score-from-removing-stones/
 */

/**
 * @author zhouhao
 * @date 2022/12/21 19:33
 */
// 数学题
public class maximumScore {
    static class Solution {
        public int maximumScore(int a, int b, int c) {
            int sum = a + b + c;
            int maxVal = Math.max(Math.max(a, b), c);
            return Math.min(sum - maxVal, sum / 2);
        }
    }

    public static void main(String[] args) {
        int a = 2, b = 4, c = 6;
        System.out.println(new Solution().maximumScore(a, b, c));
    }
}
